package com.example.administrator.architecture.db;

import com.example.administrator.architecture.db.entity.MeiZhi;

import java.util.Random;

/**
 * <pre>
 *     author : ZhaoMiXiang
 *     time   : 2017/12/04
 *     desc   : 描述
 *     version: 1.0
 * </pre>
 */
public class MeiZhiGenerator {
    private static String[] meiZhiNames = {"春", "夏", "秋", "冬"};

    public static MeiZhi generateMeiZhi() {
        Random random = new Random();
        MeiZhi meiZhi = new MeiZhi();
        meiZhi.setName(meiZhiNames[random.nextInt(4)]);
        meiZhi.setRating(random.nextInt(5));
        meiZhi.setSaveLocal(false);
        meiZhi.setUrl(random.nextBoolean() ? "url" : "asdf");
        return meiZhi;
    }
}
