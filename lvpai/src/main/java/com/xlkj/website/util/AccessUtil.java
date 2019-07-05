package com.xlkj.website.util;

import com.alibaba.fastjson.JSONObject;
import com.xlkj.website.model.UserWithBLOBs;
import java.util.Map;

public class AccessUtil {

    //获取信息的地址access_token和openId

    public static Map getAccessToken(UserWithBLOBs user){

        StringBuilder urlPath = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session");
        urlPath.append(String.format("?appid=%s", user.getAppId())); //小程序appid
        urlPath.append(String.format("&secret=%s", user.getSecret())); //小程序secretid
        urlPath.append(String.format("&js_code=%s", user.getCode()));
        urlPath.append(String.format("&grant_type=%s", "authorization_code"));
        String object = HttpUtil.sendGet(urlPath.toString());

        /*  Response response = client.newCall(request).execute();
          String resultJson = response.body().string();*/
        /** 正确返回示例
         * "access_token":"ACCESS_TOKEN",
         * "expires_in":7200,
         * "refresh_token":"REFRESH_TOKEN",
         * "openid":"OPENID",
         * "scope":"SCOPE",
         * "unionid":"o6_bmasdasdsad6_2sgVt7hMZOPfL"
         */
        Map parseObject = JSONObject.parseObject(object, Map.class);
        //将json专还成map，方便取值
        String openId = (String)parseObject.get("openid");
        if (openId != null){//有token说明请求正确，返回Map信息



            return parseObject;
        }
        return null;
    }



}
