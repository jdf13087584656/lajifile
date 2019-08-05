package com.xlkj.website.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
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
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static com.google.zxing.client.j2se.MatrixToImageWriter.toBufferedImage;

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
    public String createQRCode(@RequestParam(required = true) @ApiParam("openId") String openId, HttpServletRequest request, HttpServletResponse response) {
        String binary = null;
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(
                    openId, BarcodeFormat.QR_CODE, 200, 200, hints);
            // 1、读取文件转换为字节数组
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedImage image = toBufferedImage(bitMatrix);
            //转换成png格式的IO流
            ImageIO.write(image, "png", out);
            byte[] bytes = out.toByteArray();

            // 2、将字节数组转为二进制
            BASE64Encoder encoder = new BASE64Encoder();
            binary = encoder.encodeBuffer(bytes).trim();
        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return binary;
    }
}
