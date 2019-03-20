package com.toycar.hotelserver.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

public class JSONUtil {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    private static JsonParser parser = new JsonParser();

    public static JsonObject generateJsonObjectWithCodeAndObj(int code , Object any){
        JsonObject object = new JsonObject();
        object.addProperty("code",code);
        object.add("data",parser.parse(gson.toJson(any)));
        return object;
    }

    public static JsonObject generateJsonWithToken(int code , Object any , String token){
        JsonObject object = generateJsonObjectWithCodeAndObj(code,any);
        object.addProperty("token",token);
        return object;
    }

}
