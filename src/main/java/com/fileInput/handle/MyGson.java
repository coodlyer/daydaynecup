package com.fileInput.handle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by liyang on 15/4/15.
 */
public class MyGson {
    private static Gson myGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static Gson getInstance() {
        return myGson;
    }
}
