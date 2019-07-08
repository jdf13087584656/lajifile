package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.mapper.FileInfoMapper;
import com.xlkj.website.model.FileInfo;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.PictureService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

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
    @Autowired
    FileInfoMapper fileInfoMapper;
    @ApiOperation(value = "首页图片新增接口", httpMethod = "POST")
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
  /*  @ApiOperation(value = "首页轮播图下载接口", httpMethod = "POST")
    @RequestMapping(value = "/addPicture", method = RequestMethod.POST)
    @AuthPass
    public ResultVo getPic(@RequestParam("picName")String filepath) {
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
*/

    @ApiOperation(value = "图片下载接口", httpMethod = "GET")
    @RequestMapping(value = "/getPicture")
    public void getimg( @RequestParam("address") String address, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultVo resultVo = new ResultVo<>();
        FileInfo fileByAdr = fileInfoMapper.getFileByAdr(address);
        String fileName = fileByAdr.getFilename();
//        String fileName = "123.jpg";
        String downloadUrl = address;
        InputStream inStream = null;
        BufferedInputStream bis = null;
        try {
            //IE
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
                //其他浏览器
            } else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {

            //response.setHeader("content-type", "application/octet-stream");
            //response.setContentType("application/octet-stream");
            response.setContentType("multipart/form-data;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 读出文件到response
            // 这里是先需要把要把文件内容先读到缓冲区
            // 再把缓冲区的内容写到response的输出流供用户下载
            inStream = new FileInputStream(downloadUrl);
            bis = new BufferedInputStream(inStream);
            byte[] b = new byte[bis.available()];
            bis.read(b);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            response.getOutputStream().flush();
        }catch (IOException e){
            resultVo.resultFail("网络异常,上传失败");
            logger.error("addPicture is error", e.getMessage());
        }finally{
            // releases any system resources associated with the stream
            if(inStream!=null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @ApiOperation(value = "首页展示图片查询接口", httpMethod = "GET")
    @RequestMapping(value = "/getPictures")
    @AuthPass
    public ResultVo findPic(@RequestParam Integer types) {
        ResultVo resultVo = new ResultVo<>();
        try {
            logger.info(String.format("getPictures is start"));
            List<FileInfo> pictures = fileInfoMapper.getPictures(types);
            resultVo.resultSuccess(pictures);
        }catch (Exception e){
            resultVo.resultFail("网络异常,上传失败");
            logger.error("getPictures is error", e.getMessage());
        }
        return resultVo;
    }



}

