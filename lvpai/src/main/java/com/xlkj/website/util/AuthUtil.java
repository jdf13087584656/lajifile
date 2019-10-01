package com.xlkj.website.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import net.sf.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Auther: Admin
 * @Date: 2019/9/27 14:05
 * @Description:
 */
public class AuthUtil {
    public static final String APPID = "wxaa487dc4bf8a8898";
    public static final String APPSECRET = "07f0c840cf33243a95741ff43c6e5ee0";//.商家的app密钥
    public static final String MCHID = "1537396521";
    public static final String PATERNERKEY = "hhhhnnnnllllvvvvppppkkkkjjjj11112222";
    public static final String CERTPATH = "/pem/apiclient_cert.p12";

    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
        JSONObject jsonObject = null;
        // 首先初始化HttpClient对象
        DefaultHttpClient client = new DefaultHttpClient();
        // 通过get方式进行提交
        HttpGet httpGet = new HttpGet(url);
        // 通过HTTPclient的execute方法进行发送请求
        HttpResponse response = client.execute(httpGet);
        // 从response里面拿自己想要的结果
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = jsonObject.fromObject(result);
        }
        // 把链接释放掉
        httpGet.releaseConnection();
        return jsonObject;
    }

    /**
     * @Title: getRequestIp
     * @Description: 获取用户的ip地址
     * @param:
     * @return:
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.indexOf(",") != -1) {
            String[] ips = ip.split(",");
            ip = ips[0].trim();
        }
        return ip;
    }

}
