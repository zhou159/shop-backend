package com.zhou.shop.apiServer.service.impl.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.dto.BlogDTO;
import com.zhou.shop.api.entity.blog.Blog;
import com.zhou.shop.api.vo.BlogVO;
import com.zhou.shop.apiServer.common.CommonMethodStatic;
import com.zhou.shop.apiServer.mapper.blog.BlogMapper;
import com.zhou.shop.apiServer.mapper.user.UserMapper;
import com.zhou.shop.apiServer.service.blog.IBlogService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author 周雄
 * @date 2022/3/26 17:22
 * @description
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
    private final BlogMapper blogMapper;
    private final UserMapper userMapper;

    private final Logger log = LoggerFactory.getLogger(BlogServiceImpl.class);

    public BlogServiceImpl(
            BlogMapper blogMapper, UserMapper userMapper) {
        this.blogMapper = blogMapper;
        this.userMapper = userMapper;
    }

    @Override
    public RestObject<List<BlogDTO>> queryListDto() {
        List<Blog> blogs = blogMapper.selectList(null);
        return RestResponse.makeOkRsp(
                blogs.stream()
                        .map(
                                it -> {
                                    BlogDTO blogDto = new BlogDTO();
                                    BeanUtils.copyProperties(it, blogDto);
                                    blogDto.setBlogCreatedName(
                                            userMapper
                                                    .selectById(it.getBlogCreatedBy())
                                                    .getUsername());
                                    return blogDto;
                                })
                        .collect(Collectors.toList()));
    }

    @Override
    public RestObject<List<Blog>> queryBlogByBlogCategoryId(String blogCategoryId) {
        return RestResponse.makeOkRsp(
                blogMapper.selectList(
                        new QueryWrapper<Blog>().eq("blog_category", blogCategoryId)));
    }

    @Override
    public RestObject<BlogDTO> queryById(String id) {
        Blog blog = blogMapper.selectById(id);
        BlogDTO blogDto = new BlogDTO();
        BeanUtils.copyProperties(blog, blogDto);
        blogDto.setBlogCreatedName(userMapper.selectById(blogDto.getBlogCreatedBy()).getUsername());
        return RestResponse.makeOkRsp(blogDto);
    }

    @Override
    public RestObject<String> createBlog(BlogVO blogVO) {
        final Blog blog = new Blog();
        BeanUtils.copyProperties(blogVO, blog);
        blog.setBlogTextIntro(blogTextOptimization(blogVO.getBlogText()));
        blog.setBlogCreateTime(LocalDateTime.now());
        final int insert = blogMapper.insert(blog);
        return insert > 0 ? RestResponse.makeOkRsp("发布成功!") : RestResponse.makeErrRsp("发布失败!");
    }

    @Override
    public RestObject<String> updateBlog(BlogVO blogVO) {
        final Blog blog = new Blog();
        BeanUtils.copyProperties(blogVO, blog);
        blog.setBlogTextIntro(blogTextOptimization(blogVO.getBlogText()));
        blog.setBlogUpdateTime(LocalDateTime.now());
        final int i = blogMapper.updateById(blog);
        return i > 0 ? RestResponse.makeOkRsp("修改成功!") : RestResponse.makeErrRsp("修改失败!");
    }

    @Override
    public RestObject<String> deleteBlog(String blogId) {
        final Blog blog = blogMapper.selectById(blogId);
        CommonMethodStatic.checkUserId(blog.getBlogCreatedBy(), "该博客非您创建，无权删除!");
        final int i = blogMapper.deleteById(blogId);
        return i > 0 ? RestResponse.makeOkRsp("删除成功!") : RestResponse.makeErrRsp("删除失败!");
    }

    // 行内匹配，粗体正则 √
    private final static String MARKDOWN_BOLD_REGEXP = "([\\*_]{2})(.*?)\\1";
    // 行内匹配，斜体正则 √
    private final static String MARKDOWN_ITALIC_REGEXP = "(?<![\\*_])(\\*|_)([^\\*_]+?)\\1";
    // 行内匹配，删除线正则，匹配 ~~red~~ √
    private final static String MARKDOWN_DELETE_LINE_REGEXP = "(~~)(.*?)\\1";
    // 行内匹配，普通链接正则，匹配 []() √
    private final static String MARKDOWN_SIMPLE_LINK_REGEXP = "(?<!!)\\[(.*?)]\\((.*?)\\)";
    // 行内匹配，行内代码正则，匹配 ``
    private final static String MARKDOWN_LINE_CODE_REGEXP = "(?!<`)(`)([^`]+?)`(?!`)";

    // 单行匹配，目录标识[[toc]]
    private final static String TOC_REGEXP = "\\[\\[toc]]";
    // 单行匹配，标题正则 √
    private final static String MARKDOWN_TITLE_REGEXP = "(#{1,6}) (.*)";
    // 单行匹配，图片链接正则，匹配 ![]() √
    private final static String MARKDOWN_IMAGE_LINK_REGEXP = "^!\\[(.*?)\\]\\((.*?)\\)(\\{{1,3}.*)$";
    // 单行匹配，分割线正则，匹配 ***或---或___ √
    private final static String MARKDOWN_SEPARATE_LINE_REGEXP = "^(\\*|-|_)*$";

    // 单行匹配，多行作用，无序列表正则 √
    private final static String MARKDOWN_UNORDERED_LIST_REGEXP = "^([-\\+\\*]) (.*)";
    // 单行匹配，多行作用，有序列表正则 √
    private final static String MARKDOWN_ORDERED_LIST_REGEXP = "^([\\d+])\\.\\s(.*)";
    // 单行匹配，多行作用，简单引用正则 √
    private final static String MARKDOWN_SIMPLE_QUOTE_REGEXP = "^([>] ?)(.*)";
    // 单行匹配，多行作用，表格行正则，匹配 |表格列内容|表格列内容| √
    private final static String MARKDOWN_TABLE_ROW_REGEXP = "^(\\|)(.*?)\\|$";
    // 匹配代码块的开头
    private final static String MARKDOWN_CODE_BLOCK_START_REGEXP = "^[`]{3}\\s*\\w+$";
    // 匹配代码块的结尾
    private final static String MARKDOWN_CODE_BLOCK_END_REGEXP = "^[`]{3}$";
    // 匹配tip开头 ::: tip
    private final static String TIP_BLOCK_START_REGEXP = "^::: .*";
    // 匹配tip结尾 ::: tip
    private final static String TIP_BLOCK_END_REGEXP = "^:::";
    // 匹配emoji表情 :m: :m::m:
    private final static String EMOJI_REGEXP = ":.*:";

    private String regexp(String s){
        // 粗体
        Matcher boldMatcher = Pattern.compile(MARKDOWN_BOLD_REGEXP).matcher(s);
        if (boldMatcher.find()) {
            s = boldMatcher.replaceAll("$2");
        }

        // 斜体
        Matcher italicMatcher = Pattern.compile(MARKDOWN_ITALIC_REGEXP).matcher(s);
        if (italicMatcher.find()) {
            s = italicMatcher.replaceAll("$2");
        }

        // 删除线
        Matcher deleteLineMatcher = Pattern.compile(MARKDOWN_DELETE_LINE_REGEXP).matcher(s);
        if (deleteLineMatcher.find()) {
            s = deleteLineMatcher.replaceAll("$2");
        }

        // 普通链接
        Matcher simpleLinkMatcher = Pattern.compile(MARKDOWN_SIMPLE_LINK_REGEXP).matcher(s);
        if (simpleLinkMatcher.find()) {
            s = simpleLinkMatcher.replaceAll("$2");
        }

        // 行内代码
        Matcher lineCodeMatcher = Pattern.compile(MARKDOWN_LINE_CODE_REGEXP).matcher(s);
        if (lineCodeMatcher.find()) {
            s = lineCodeMatcher.replaceAll("$2");
        }

        Matcher tocMatcher = Pattern.compile(TOC_REGEXP).matcher(s);
        if (tocMatcher.find()) {
            s = tocMatcher.replaceAll("");
        }
        // 标题行
        Matcher titleMatcher = Pattern.compile(MARKDOWN_TITLE_REGEXP).matcher(s);
        if (titleMatcher.find()) {
            s = titleMatcher.replaceAll("$2");
        }

        // 图片链接行，注意图片链接中如果匹配到斜体的"_"可能无法解析
        Matcher imageLinkMatcher = Pattern.compile(MARKDOWN_IMAGE_LINK_REGEXP).matcher(s);
        if (imageLinkMatcher.find()) {
            s = imageLinkMatcher.replaceAll("$2");
        }

        // 分隔线行
        Matcher separateLineMatcher = Pattern.compile(MARKDOWN_SEPARATE_LINE_REGEXP).matcher(s);
        if (separateLineMatcher.find()) {
            s = separateLineMatcher.replaceAll("$1");
        }

        // 无序列表
        Matcher unorderedListMatcher = Pattern.compile(MARKDOWN_UNORDERED_LIST_REGEXP).matcher(s);
        if (unorderedListMatcher.find()) {
            s = unorderedListMatcher.replaceAll("$2");
        }

        // 有序列表
        Matcher orderedListMatcher = Pattern.compile(MARKDOWN_ORDERED_LIST_REGEXP).matcher(s);
        if (orderedListMatcher.find()) {
            s = orderedListMatcher.replaceAll("$2");
        }

        // 简单引用
        Matcher simpleQuoteMatcher = Pattern.compile(MARKDOWN_SIMPLE_QUOTE_REGEXP).matcher(s);
        if (simpleQuoteMatcher.find()) {
            s = simpleQuoteMatcher.replaceAll("$2");
        }

        //表格，直接去除
        Matcher tableRowMatcher = Pattern.compile(MARKDOWN_TABLE_ROW_REGEXP).matcher(s);
        if (tableRowMatcher.find()) {
            s = tableRowMatcher.replaceAll("");
        }

        // 代码块开头
        Matcher codeBlockStartMatcher = Pattern.compile(MARKDOWN_CODE_BLOCK_START_REGEXP).matcher(s);
        if (codeBlockStartMatcher.find()) {
            s = codeBlockStartMatcher.replaceAll("");
        }

        // 代码块结尾
        Matcher codeBlockEndMatcher = Pattern.compile(MARKDOWN_CODE_BLOCK_END_REGEXP).matcher(s);
        if (codeBlockEndMatcher.find()) {
            s = codeBlockEndMatcher.replaceAll("");
        }

        // tip块开头
        Matcher tipBlockStartMatcher = Pattern.compile(TIP_BLOCK_START_REGEXP).matcher(s);
        if (tipBlockStartMatcher.find()) {
            s = tipBlockStartMatcher.replaceAll("");
        }

        // tip块结尾
        Matcher tipBlockEndMatcher = Pattern.compile(TIP_BLOCK_END_REGEXP).matcher(s);
        if (tipBlockEndMatcher.find()) {
            s = tipBlockEndMatcher.replaceAll("");
        }

        // emoji表情
        Matcher emojiMatcher = Pattern.compile(EMOJI_REGEXP).matcher(s);
        if (emojiMatcher.find()) {
            s = emojiMatcher.replaceAll("");
        }

        return s;
    }

    /**
     * 博客内容优化
     * 保留纯文本，将超出100字符之后的替换成...
     * @param s 原字符串
     * @return 优化后的字符串
     */
    private String blogTextOptimization(String s){
        StringBuilder returnS = new StringBuilder();
        String[] split = s.split("\n");
        for (String value : split) {
            returnS.append(regexp(value));
            if (returnS.length() > 100) {
                returnS = new StringBuilder(returnS.substring(0,100));
                returnS.append("...");
                break;
            }
        }

        return returnS.toString();
    }
}
