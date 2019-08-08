package com.xlkj.website.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CommonController extends BaseController {

//    @RequestMapping(value = "/qrcode",method = RequestMethod.GET)
//    @ApiOperation(value = "二维码接口", httpMethod = "GET")
//    @AuthPass
//    public void getEquipmentQrcode(@RequestParam("num") int num) {
//        try {
//            log.info("qrcode:生成二维码,");
//            Result result = new Result();
//            for (int i = 0; i < num; i++) {
//
//            String lphs = NumberUtil.getNumRadm("LPHS");
//            //生成二维码
//            try {
//                CodeToWord.getQRCode(lphs,"乐派环境","C:\\Users\\Admin\\Desktop\\pict",lphs);
////
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            }
//        } catch (Exception e){
//          e.getStackTrace();
//        }
//    }
}