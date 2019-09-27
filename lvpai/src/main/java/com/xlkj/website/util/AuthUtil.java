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
    public static final String PATERNERKEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDar3QZfLv1hk5g4IcpNFNeQgN5MuxqDpWfXm0UPOkV8/gaHRV62BoT1611pHx12ZanvBNiC1HQ0BFNRRq3GGUvbrmcEzwYQhFcDu43x4WYtuAMIyklgwlUJZoUIQn+PNdiqVkuSr/Famlx36zgtmdIhWlcxXb3dUsNSB5MIik//sDXdmEPFrN/tYh0hM9dw2uEYbnGXENC8UqHGGFLOBBsBOV2UUReyFDRMTjT/lKjoDrDchIZEMP3H4M2Q6VdEmMxdB+Q3VAaI6Kct8Dj4kXWZo9JtJyU86V3IYSZ9NMv8ny4KeZSMR7AAYz9pyne2p5S6zaa1FV86zNOlbwKyT55AgMBAAECggEBAKJhO40dUJfMJXDL57DR2MGZtOiOxnst3y3aOJaZb93MLUJ+rA9uXVa0hGlhPMVpTvO3tJDNpO+vP9mnYWHpLGEfD5VztuCwViGMOJiUf3/Y8t4wUYI4HXos/Y7KxZfRZ4EsDDtSZ7lX/Xn/w2eMKX7xCT5IpcCziIoRLeYMS6Lm0ImYK2tp2nTsB6tT68DQlm7ddlqoc4Le/9w46NB4VmMC3hcXVcPy9GxYMlR8g0bcewiT5XAncNbIqQcrCJ3RdOhMRuM6vZDri21B3OC/4hQXrqSK527xZehz2w+C2K5hVDnrXlotOLQqKTjt/wxdXbNdV/KAa7mUIWnNuR8sQjECgYEA9JA2SvBM5DCE5kAMKktgBEJ1/tgztF4I+UQQGG+4WZHyOyI10sIP7Y6qoVjUn3cxPM2NRjd7fXpU9vi2Q7+uKvx0szFo3XadOvEtHe1NWrLBsJsNA3iyOaVCqnZaBxMwoL5DD55CaGJXWtt0dmDobJ5SoekBgbLRKlFQwKLihQ0CgYEA5OlxkBy1e7aUpB+L5gAbDVLvM3pZ3u2l5cpakmJBYvf3zG8GGMS8AU9Ts6NMIIENfyAdwkUJZkAN2+y6HSnrXMPEH8Oq1sWr5AMoD7lu1Qi17SSEYh8Tfw24742nr1iGEDVD512k2RGIemjSR0cw2omduWDKn+4FtpN1/E+t3B0CgYBp4f3/l+ZSbUc8wMIDlbquXW/ktAo+ru/Hq9YkHkp8TRnIzFjtNKPcwAXT8TetCtfAcWYW3nKSsuISQz/2OQjZB5Am/N9f8rjECiL0cAcrm3UMVzTdKeZP2uLwFmmH4qENFxLFskkiFGGprpXPosk+LZWtD8pdMuQoJCiIHn1gCQKBgQCmunlik+aDoyqEmA2XioAppjxfbEBFJSbuRgLOGA6z/RRZrIvuQm0FLzgx4UCzdAvWihfixdHgzcrKYpP0ZfHt8RDKagPmxrc6LiphuZhGRj/r5+scZLIYmnAW20BFcN7Es2cv/37wM9sJ/YsbK3kj05Qzz5IGBqHWp3UKPybM6QKBgBGyFODv9+TcplpAh/1h7GOyGPwq8bKaG/C14/sUX0JGnpSe+zIrxCEJV7ROlGSf12PlyoVhblGT5ZVxuj/w31KqwwVH/l3D8O0laqoCeTznnJyIyR5KsgNGGPbuL2RFPEyBHoHIi0UCtfFy1Pb4SwoVE7mTHTWlbEHjoJlfElti";
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
