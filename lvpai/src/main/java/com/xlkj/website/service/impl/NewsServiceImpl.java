package com.xlkj.website.service.impl;

import com.xlkj.website.mapper.FileInfoMapper;
import com.xlkj.website.mapper.NewSMapper;
import com.xlkj.website.model.FileInfo;
import com.xlkj.website.model.NewsDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Admin
 * @Date: 2019/8/7 17:36
 * @Description:
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewSMapper newSMapper;


    @Override
    public ResultVo<Integer> addnews(NewsDto newsDto) {
        ResultVo<Integer> resultVo = new ResultVo();
        int i = newSMapper.AddNews(newsDto);
        resultVo.resultFlag(resultVo,i,"新增成功","新增失败");
        return resultVo;
    }

    @Override
    public ResultVo<List<NewsDto>> getListsNew(HttpServletRequest request, HttpServletResponse response) {
        ResultVo<List<NewsDto>> resultVo = new ResultVo<>();
        List<NewsDto> news = newSMapper.findNews();
        news.stream().map( newsDto -> {
            String base64 = getString(newsDto.getUrls(), request, response);
            newsDto.setUrls(base64);
            return newsDto;
        }).collect(Collectors.toList());
        resultVo.resultSuccess(news);
        return resultVo;
    }

    @Autowired
    FileInfoMapper fileInfoMapper;
    private String getString(String address, HttpServletRequest request, HttpServletResponse response) {
        FileInfo fileByAdr = fileInfoMapper.getFileByAdr(address);
        String fileName = fileByAdr.getFilename();
//        String fileName = "123.jpg";
        File file = new File(address);
        long size = file.length();
        byte[] imageByte = new byte[(int) size];
        String encode1 = null;
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
            BASE64Encoder encoder = new BASE64Encoder();

            bis = new BufferedInputStream(inStream);
//            byte[] b = new byte[bis.available()];

            // bis.read(b);
            bis.read(imageByte);

            encode1 = encoder.encode(imageByte);

          /*  OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            response.getOutputStream().flush();*/
        } catch (IOException e) {
          e.printStackTrace();

        } finally {
            // releases any system resources associated with the stream
            if (inStream != null) {
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

        return encode1;
    }
}
