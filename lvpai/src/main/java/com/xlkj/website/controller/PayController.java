package com.xlkj.website.controller;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.util.AuthUtil;
import com.xlkj.website.util.CertHttpUtil;
import com.xlkj.website.util.WXPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Auther: Admin
 * @Date: 2019/9/27 15:22
 * @Description:
 */
@RestController
@RequestMapping("/pay")
public class PayController {
    private Logger logger = LoggerFactory.getLogger(PayController.class);
    /**
     * @Title: transfer
     * @Description: 企业转账到零钱
     * @param:
     * @return:
     */
    @RequestMapping(value = "/payUser",method = RequestMethod.POST)
    public  ResultVo transfer(HttpServletRequest request, HttpServletResponse response, @RequestParam("opid") String opid, @RequestParam("money") String money) {
        ResultVo<String> resultVo = new ResultVo<>();
        // 1.0 拼凑企业支付需要的参数
        String appid = AuthUtil.APPID; // 微信公众号的appid
        String mch_id = AuthUtil.MCHID; // 商户号
        String nonce_str = WXPayUtil.generateNonceStr(); // 生成随机数
        String partner_trade_no = WXPayUtil.generateNonceStr(); // 生成商户订单号
        String openid = opid; // 支付给用户openid
        String check_name = "NO_CHECK"; // 是否验证真实姓名呢
        String re_user_name = "KOLO"; // 收款用户姓名(非必须)
        String amount = money; // 企业付款金额，最少为100，单位为分
        String desc = "恭喜你，完成了一个代买订单a6w3fswq51asdf6！"; // 企业付款操作说明信息。必填。
        String spbill_create_ip = AuthUtil.getRequestIp(request); // 用户的ip地址

        // 2.0 生成map集合
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("mch_appid", appid); // 微信公众号的appid
        packageParams.put("mchid", mch_id); // 商务号
        packageParams.put("nonce_str", nonce_str); // 随机生成后数字，保证安全性

        packageParams.put("partner_trade_no", partner_trade_no); // 生成商户订单号
        packageParams.put("openid", openid); // 支付给用户openid
        packageParams.put("check_name", check_name); // 是否验证真实姓名呢
        packageParams.put("re_user_name", re_user_name);// 收款用户姓名
        packageParams.put("amount", amount); // 企业付款金额，单位为分
        packageParams.put("desc", desc); // 企业付款操作说明信息。必填。
        packageParams.put("spbill_create_ip", spbill_create_ip); // 调用接口的机器Ip地址

        try {
            // 3.0 利用上面的参数，先去生成自己的签名
            String sign = WXPayUtil.generateSignature(packageParams, AuthUtil.PATERNERKEY);

            // 4.0 将签名再放回map中，它也是一个参数
            packageParams.put("sign", sign);

            // 5.0将当前的map结合转化成xml格式
            String xml = WXPayUtil.mapToXml(packageParams);

            // 6.0获取需要发送的url地址
            String wxUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; // 获取退款的api接口


            System.out.println("发送前的xml为：" + xml);

            // 7,向微信发送请求转账请求
            String returnXml = CertHttpUtil.postData(wxUrl, xml, AuthUtil.MCHID, AuthUtil.CERTPATH);

            System.out.println("返回的returnXml为:" + returnXml);

            // 8，将微信返回的xml结果转成map格式
            Map<String, String> returnMap = WXPayUtil.xmlToMap(returnXml);

            if (returnMap.get("return_code").equals("SUCCESS")) {
                // 付款成功
                System.out.println("returnMap为:" + returnMap);
                logger.info(returnMap.get("return_msg"));
                resultVo.resultSuccess("提现成功");
            }else {
                logger.info(returnMap.get("return_msg"));
                resultVo.resultFail("网络异常");
            }

            return resultVo;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resultVo.resultFail("网络异常");
        }
        return resultVo;
    }

}
