package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.HomePageOrderDto;
import com.xlkj.website.model.NewsDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Admin
 * @Date: 2019/8/7 16:56
 * @Description:
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    private Logger logger = LoggerFactory.getLogger(NewsController.class);
    @ApiOperation(value = "咨询新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    @AuthPass
    public ResultVo addNews(@RequestBody NewsDto newsDto) {
        ResultVo<HomePageOrderDto> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addNews is start"));
            resultVo = newsService.addnews(newsDto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addNews is error", e.getMessage());
        }
        return resultVo;
    }
    @ApiOperation(value = "咨询查询接口", httpMethod = "POST")
    @RequestMapping(value = "/getNews", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<NewsDto>> getNews() {
        ResultVo<List<NewsDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("getNews is start"));
            resultVo = newsService.getListsNew();
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("getNews is error", e.getMessage());
        }
        return resultVo;
    }
}
