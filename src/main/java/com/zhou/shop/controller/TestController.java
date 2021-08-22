package com.zhou.shop.controller;

import com.zhou.shop.entity.Test;
import com.zhou.shop.enums.Source;
import com.zhou.shop.service.ITestService;
import com.zhou.shop.util.RandomUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.UUID;

/**
 * @author Administrator
 */
@EnableScheduling
@RestController
@RequestMapping("/test")
public class TestController {
    final ITestService iTestService;

    public TestController(ITestService iTestService) {
        this.iTestService = iTestService;
    }

//    @Scheduled(cron = "0/5 * * * * * ")
    public void testCron(){
        Test test = new Test();
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase(Locale.ROOT);
        String random1 = RandomUtil.createRandom(50, Source.symbolNumLetter, Source.symbolNumLetter.getSources().length());
        String random2 = RandomUtil.createRandom(20, Source.numLetter, Source.numLetter.getSources().length());
        String random3 = RandomUtil.createRandom(9, Source.num, Source.num.getSources().length());
        String random4 = RandomUtil.createRandom(23, Source.china, Source.china.getSources().length());
        String random5 = RandomUtil.createRandom(9, Source.num, Source.num.getSources().length());
        String random6 = RandomUtil.createRandom(15, Source.china, Source.china.getSources().length());
        String random7 = RandomUtil.createRandom(215, Source.symbolNumLetter, Source.symbolNumLetter.getSources().length());
        String random8 = RandomUtil.createRandom(12, Source.china, Source.china.getSources().length());
        String random9 = RandomUtil.createRandom(30, Source.numLetter, Source.numLetter.getSources().length());
        String random10 = RandomUtil.createRandom(25, Source.china, Source.china.getSources().length());
        test.setTestId(uuid);
        test.setTestT1(random1);
        test.setTestT2(random2);
        test.setTestT3(random3);
        test.setTestT4(random4);
        test.setTestT5(random5);
        test.setTestT6(random6);
        test.setTestT7(random7);
        test.setTestT8(random8);
        test.setTestT9(random9);
        test.setTestT10(random10);
        iTestService.save(test);
    }
}
