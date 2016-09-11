package com.common;

import java.util.Random;
import java.util.UUID;

/**
 * Created by 祎婷 on 2014/12/2.
 */
public class IDCreater {
    /**
     * 生成 32 位 ID
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();

    }
    public static long createId(){
        Random random = new Random();
        return random.nextInt(100000000);

    }

}
