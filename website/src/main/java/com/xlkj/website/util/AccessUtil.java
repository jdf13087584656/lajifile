package com.xlkj.website.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.UserWithBLOBs;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class AccessUtil {

    //获取信息的地址access_token和openId
    private static final String ACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    private static final String WECHATUSERINFO = "https://api.weixin.qq.com/sns/userinfo";

    public static Map getAccessToken(String code,String appId,String secret){

        String url = new StringBuilder(ACCESSTOKEN)
                .append("?grant_type=authorization_code&appid=").append(appId).append("&secret=")
                .append(secret).append("&code=").append(code).toString();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            String resultJson = response.body().string();
            /** 正确返回示例
             * "access_token":"ACCESS_TOKEN",
             * "expires_in":7200,
             * "refresh_token":"REFRESH_TOKEN",
             * "openid":"OPENID",
             * "scope":"SCOPE",
             * "unionid":"o6_bmasdasdsad6_2sgVt7hMZOPfL"
             */
            Map parseObject = JSONObject.parseObject(resultJson, Map.class);
            //将json专还成map，方便取值
            String access_token = (String)parseObject.get("access_token");
            if (access_token != null){//有token说明请求正确，返回Map信息
                return parseObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UserWithBLOBs getUserInfo(String openId,String accessToken){
        String url = new StringBuilder(WECHATUSERINFO).append("?openid=").append(openId)
                .append("&access_token=").append(accessToken).toString();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            String resultJson = response.body().string();
            /**正确的返回信息
             * {
             * "openid":"OPENID",
             * "nickname":"NICKNAME",
             * "sex":1,
             * "province":"PROVINCE",
             * "city":"CITY",
             * "country":"COUNTRY",
             * "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
             * "privilege":[
             * "PRIVILEGE1",
             * "PRIVILEGE2"
             * ],
             * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
             * }
             */
            Map parseObject = JSONObject.parseObject(resultJson, Map.class);
            String id = (String)parseObject.get("openid");
            if (id != null){//成功获取用户信息
                String nickname = (String)parseObject.get("nickname");
                Integer sex = (Integer)parseObject.get("sex");
                String province = (String)parseObject.get("province");
                String city = (String)parseObject.get("city");
                String headimgurl = (String)parseObject.get("headimgurl");
                UserWithBLOBs user = new UserWithBLOBs();
                user.setUserName(nickname);
                user.setOpenId(openId);
                user.setUserImg(headimgurl);
                user.setCity(city);
                user.setProvince(province);
                user.setSex(sex);
                //这里只选了三个字段，根据自己的业务选择更多的字段
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
