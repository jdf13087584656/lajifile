package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.PictureService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: Admin
 * @Date: 2019/7/7 14:42
 * @Description:
 */

@RestController
@RequestMapping("/picture")
public class PictureController {

    private Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    PictureService pictureService;

    @ApiOperation(value = "首页轮播图新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addPicture", method = RequestMethod.POST)
    @AuthPass
    public ResultVo addPic(@RequestParam("file")MultipartFile multipartFile,@RequestParam("picName")String picName) {
        ResultVo resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addPicture is start"));
            resultVo = pictureService.addPic(multipartFile,picName);
        }catch (Exception e){
            resultVo.resultFail("网络异常,上传失败");
            logger.error("addPicture is error", e.getMessage());
        }
        return resultVo;
    }

}
