package com.xlkj.website.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xlkj.website.annotation.AuthPass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshuo on 2018/11/16.
 */
@RestController
@RequestMapping(value = "/QRCode")
@CrossOrigin
public class QRCodeController  {

    private Logger logger = LoggerFactory.getLogger(QRCodeController.class);


    //动态生成二维码
    @ApiOperation("动态生成二维码")
    @RequestMapping(value = {"/createQRCode"}, method = {RequestMethod.GET})
    @AuthPass
    public String createQRCode(@RequestParam(required = true) @ApiParam("dispatchId") String openId, HttpServletRequest request, HttpServletResponse response) {
        try {
            //二维码中包含的信息
            String content = new sun.misc.BASE64Encoder().encode((openId).getBytes("UTF-8"));//数据进行base64加密
            Map<EncodeHintType, Object> hints = new HashMap<>();
            // 指定编码格式
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 0);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
            // 编码内容,编码类型(这里指定为二维码),生成图片宽度,生成图片高度,设置参数
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 256, 256, hints);
            //1.1去白边
            int[] rec = bitMatrix.getEnclosingRectangle();
            int resWidth = rec[2] + 1;
            int resHeight = rec[3] + 1;
            BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
            resMatrix.clear();
            for (int i = 0; i < resWidth; i++) {
                for (int j = 0; j < resHeight; j++) {
                    if (bitMatrix.get(i + rec[0], j + rec[1])) {
                        resMatrix.set(i, j);
                    }
                }
            }
            //设置请求头
            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + "qrcode.png");
            OutputStream outputStream = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            logger.error("生成图片失败！" + e.getMessage(), e);
        }
        return null;
    }
}
