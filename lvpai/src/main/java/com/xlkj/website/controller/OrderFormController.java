package com.xlkj.website.controller;

import com.xlkj.website.model.CommonSearch;
import com.xlkj.website.model.OrderFormAddDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SelectOrderDto;
import com.xlkj.website.service.OrderFormService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Description: 订单管理
 */
@RestController
@RequestMapping(value = "/orderForm")
@CrossOrigin
public class OrderFormController {
    @Autowired
    private OrderFormService orderFormService;

    private Logger logger = LoggerFactory.getLogger(OrderFormController.class);

    @ApiOperation(value = "订单新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addOrderForm", method = RequestMethod.POST)
    public ResultVo<Integer> addOrderForm(@RequestBody OrderFormAddDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addOrderForm is start"));
            resultVo = orderFormService.addOrderForm(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addOrderForm is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "订单修改接口", httpMethod = "POST")
    @RequestMapping(value = "/modifyOrderForm", method = RequestMethod.POST)
    public ResultVo<Integer> modifyOrderForm(@RequestBody OrderFormAddDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyOrderForm is start"));
            resultVo = orderFormService.modifyOrderForm(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("modifyOrderForm is error", e.getMessage());
        }
        return resultVo;
    }


    @ApiOperation(value = "订单列表接口", httpMethod = "POST")
    @RequestMapping(value = "/listOrderForm", method = RequestMethod.POST)
    public ResultVo<List<OrderFormAddDto>> listOrderForm(@RequestBody SelectOrderDto dto) {
        ResultVo<List<OrderFormAddDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listOrderForm is start"));
            resultVo = orderFormService.listOrderForm(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("listOrderForm is error", e.getMessage());
        }
        return resultVo;
    }
}
