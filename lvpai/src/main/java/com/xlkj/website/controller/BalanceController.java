package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.AddBalanceDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.BalanceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Description: 余额
 */
@RestController
@RequestMapping(value = "/balance")
@CrossOrigin
public class BalanceController {
    private Logger logger = LoggerFactory.getLogger(BalanceController.class);
    @Autowired
    private BalanceService balanceService;

    @ApiOperation(value = "余额新增", httpMethod = "POST")
    @RequestMapping(value = "/addBalance", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> addBalance(@RequestBody AddBalanceDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addBalance is start"));
            resultVo = balanceService.addBalance(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addBalance is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "余额查询", httpMethod = "POST")
    @RequestMapping(value = "/searchBalance", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<AddBalanceDto> searchBalance(@RequestBody String openId) {
        ResultVo<AddBalanceDto> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("searchBalance is start"));
            resultVo = balanceService.searchBalance(openId);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("searchBalance is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "余额修改", httpMethod = "POST")
    @RequestMapping(value = "/modifyBalance", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> modifyBalance(@RequestBody AddBalanceDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyBalance is start"));
            resultVo = balanceService.modifyBalance(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("modifyBalance is error", e.getMessage());
        }
        return resultVo;
    }

}
