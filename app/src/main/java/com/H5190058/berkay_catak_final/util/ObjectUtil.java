package com.H5190058.berkay_catak_final.util;

import com.H5190058.berkay_catak_final.model.KayipModel;
import com.google.gson.Gson;

public class ObjectUtil {
    public static String kayipToJsonString(KayipModel kayip){
        Gson gson = new Gson();
        return gson.toJson(kayip);
    }
    public static KayipModel jsonStringToKayip(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, KayipModel.class);
    }
}
