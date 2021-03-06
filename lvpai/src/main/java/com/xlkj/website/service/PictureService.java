package com.xlkj.website.service;

import com.xlkj.website.model.PictureDto;
import com.xlkj.website.model.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: Admin
 * @Date: 2019/7/7 14:51
 * @Description:
 */

public interface PictureService {

    ResultVo addPic(PictureDto pictureDto,MultipartFile multipartFile);
    ResultVo getPic(String filePath);
}
