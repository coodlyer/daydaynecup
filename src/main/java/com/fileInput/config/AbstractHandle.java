package com.fileInput.config;

import com.fileInput.handle.MyGson;
import com.google.gson.Gson;

/**
 * Created by liyang on 15/4/15.
 */
public class AbstractHandle {
    protected Gson gson = MyGson.getInstance();
}
