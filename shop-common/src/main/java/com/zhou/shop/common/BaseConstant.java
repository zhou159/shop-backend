package com.zhou.shop.common;

import java.io.File;

/**
 * 基础常量池
 *
 * @author 周雄
 * @description: 基础常量池
 * @version: v1.0 22.6.9 创建
 * @since 2022/6/9 15:48
 */
public class BaseConstant {

    /*=====时间戳格式  Timestamp format=====*/
    public static final String API_RESULT_DATA_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String COMMON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /*=====常用数字，字符串 Common numbers, strings=====*/
    public static final Integer MAP_DEFAULT_SIZE = 16;
    public static final String ONE_STR = "1";
    public static final String ZERO_STR = "0";
    public static final String NULL_STR = "null";
    public static final String NULL_STR_UPPER = "NULL";
    public static final String TRUE_STR = "true";
    public static final String FALSE_STR = "false";
    public static final boolean TRUE_BOOL = true;
    public static final boolean FALSE_BOOL = false;

    /*=====接口状态码返回值及说明 Interface status code return value and description=====*/
    public static final Integer SUCCESS_DEFAULT_CODE = 20000;
    public static final String SUCCESS_DEFAULT_MSG = "success";

    /*=====网络相关 Network related=====*/
    public static final String INNER_IP = "内网IP";
    public static final String AUTHORIZATION_TOKEN_KEY = "token";
    public static final String USER_AGENT = "User-Agent";
    public static final String LOCALHOST_IP = "127.0.0.1";
    public static final String IP_UNKNOWN = "unknown";
    public static final String WEBSITE_SUFFIX = ".com";
    public static final String WEBSITE_PREFIX = "www.";
    public static final String HTML_SUFFIX = ".html";
    public static final String NACOS_PREFIX = "lb://";

    /*=====常用编码格式 Common encoding formats=====*/
    public static final String CHARACTER_ENCODE_UTF8_LOWER = "utf-8";
    public static final String CHARACTER_ENCODE_UTF8_UPPER = "UTF-8";
    public static final String CHARACTER_ENCODE_ISO88591 = "ISO-8859-1";
    public static final String CHARACTER_ENCODE_GBK = "GBK";
    public static final String CHARACTER_ENCODE_GB2313 = "GB2313";

    /*=====常用符号  Common symbols=====*/
    public static final String SLASH = "/";
    public static final String DOUBLE_SLASH = "//";
    public static final String BACK_SLASH = "\\";
    public static final String CHARACTER_COMMA = ",";
    public static final String CONNECTOR_UNDERLINE = "_";
    public static final String DECIMAL_POINT = ".";
    public static final String REPLACE_DECIMAL_POINT = "\\.";
    public static final String BRACE_LEFT = "{";
    public static final String BRACE_RIGHT = "}";
    public static final String CHAR_AND = "&";
    public static final String DOUBLE_CHAR_AND = "&&";
    public static final String CHAR_COMMA = ",";
    public static final String CHAR_PERCENT = "%";
    public static final String CHAR_INFINITE = "∞";
    public static final String COLON = ":";
    public static final String PLACEHOLDER_BLANK_SPACE = " ";
    public static final String PLACEHOLDER_WARP_SPACE = "\n";
    public static final String DASH_LINE = "-";
    public static final String SEMICOLON = ";";
    public static final String FILE_SEPARATOR;

    /*=====常用加密方式 Common encryption methods=====*/
    public static final String EEC_SIGNATURE_TYPE = "SHA256withECDSA";
    public static final String MD5_SIGNATURE_TYPE = "md5";
    public static final String SHA_256_SIGNATURE_TYPE = "SHA-256";
    public static final String SHA_1_SIGNATURE_TYPE = "SHA-1";
    public static final String HMAC_SHA1_SIGNATURE_TYPE = "HmacSHA1";

    /*=====加密相关信息 Encryption related information=====*/
    public static final String AES_KEY = "SHOP_|-|[]AES/.H-==-KK///--_____KEY_...??//";

    /*=====token验证相关参数 Token verification related parameters=====*/
    public static final String TOKEN_USER_ID = "userId";
    public static final String TOKEN_USER_PWD = "userPassword";

    /*=====邮件相关 Email related=====*/
    public static final String MAIL_PREFIX = "【SHOP】";
    public static final String MAIL_VERIFY_CODE_SUBJECT = MAIL_PREFIX+"登录验证码";
    public static final String MAIL_VERIFY_CODE_CONTENT = MAIL_PREFIX+"您的登录验证码为：";
    public static final String MAIL_PASSWORD_SUBJECT = MAIL_PREFIX+"找回密码";
    public static final String MAIL_PASSWORD_CONTENT = MAIL_PREFIX+"您的密码是：";
    private BaseConstant() {
    }

    static {
        FILE_SEPARATOR = File.separator;
    }
}
