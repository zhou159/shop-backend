package com.zhou.shop;

import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.util.LogUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {
    @Autowired LogUtil logUtil;

    @Test
    void contextLoads() {
        logUtil.log("乌拉", LogStatus.INFO.info);
    }

    @Test
    void contextLoads2() {}
}
