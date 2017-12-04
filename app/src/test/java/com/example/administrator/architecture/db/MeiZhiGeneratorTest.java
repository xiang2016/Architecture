package com.example.administrator.architecture.db;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/04
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class MeiZhiGeneratorTest {
    @Test
    public void generateMeiZhi() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int nextInt = random.nextInt(6);
            System.out.println(nextInt);
            if (nextInt == 5) {
                return;
            }
        }
        Assert.fail("no 5");
    }
}