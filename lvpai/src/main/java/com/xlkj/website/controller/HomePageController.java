package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.CommonSearchDto;
import com.xlkj.website.model.HomePageOrderDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.HomePageService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Description: 首页
 */
@RestController
@RequestMapping(value = "/homePage")
@CrossOrigin
public class HomePageController {
    private Logger logger = LoggerFactory.getLogger(HomePageController.class);
    @Autowired
    private HomePageService homePageService;

    @ApiOperation(value = "待审批接口", httpMethod = "POST")
    @RequestMapping(value = "/spNum", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<HomePageOrderDto> spNum() {
        ResultVo<HomePageOrderDto> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("spNum is start"));
            resultVo = homePageService.countOrder();
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("spNum is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "用户数量", httpMethod = "POST")
    @RequestMapping(value = "/userNum", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> userNum(@RequestBody CommonSearchDto commonSearchDto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("userNum is start"));
            resultVo = homePageService.countUser(commonSearchDto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("userNum is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "回收站数量", httpMethod = "POST")
    @RequestMapping(value = "/equNum", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> equNum() {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("equNum is start"));
            resultVo = homePageService.countEqu();
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("equNum is error", e.getMessage());
        }
        return resultVo;
    }

}
