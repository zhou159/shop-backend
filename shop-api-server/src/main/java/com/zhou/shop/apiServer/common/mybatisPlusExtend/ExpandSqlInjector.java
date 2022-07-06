package com.zhou.shop.apiServer.common.mybatisPlusExtend;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * 扩展批量插入方法
 *
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/6 11:22
 */
public class ExpandSqlInjector extends DefaultSqlInjector {
    /**
     * 扩展mybatis-plus实现的批量插入方法。 因为只支持mysql，所以并未接入BaseMapper中，需要自己引入
     *
     * @param mapperClass 当前mapper
     * @param tableInfo
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new InsertBatchSomeColumn());
        return methodList;
    }
}
