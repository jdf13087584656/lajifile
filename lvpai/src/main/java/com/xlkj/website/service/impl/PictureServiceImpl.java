package com.xlkj.website.service.impl;

import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.PictureService;
import com.xlkj.website.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: Admin
 * @Date: 2019/7/7 14:51
 * @Description:
 */
@Service
public class PictureServiceImpl implements PictureService {

    /**
     * @Auther: jdf
     * @Date: ${DATE} ${HOUR}:${MINUTE}
     * @Description:首页轮播图新增
     */

    @Value("${system.path.basePath}")
    private String basePath;

    @Value("${system.path.activity}")
    private String activity;

    @Value("${system.path.picture}")
    private String picture;
    @Value("${system.path.server-address}")
    private String ip;
    @Override
    public ResultVo addPic(MultipartFile multipartFile,String picName) {

        ResultVo resultVo = new ResultVo<>();
        try {
            FileUtils.save(multipartFile,basePath+"/"+activity,picName);
            resultVo.resultSuccess("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            resultVo.resultFail("网络异常,上传失败");
        }


        return resultVo;
    }
}
