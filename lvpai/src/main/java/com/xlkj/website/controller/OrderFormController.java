package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.*;
import com.xlkj.website.service.OrderDetailsService;
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
    @Autowired
    private OrderDetailsService orderDetailsService;

    private Logger logger = LoggerFactory.getLogger(OrderFormController.class);

    @ApiOperation(value = "订单新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addOrderForm", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<String> addOrderForm(@RequestBody OrderFormAddDto dto) {
        ResultVo<String> resultVo = new ResultVo<>();
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
    @AuthPass
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
    @AuthPass
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

    @ApiOperation(value = "订单增垃圾袋接口", httpMethod = "POST")
    @RequestMapping(value = "/addGarbageBag", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> addGarbageBag(@RequestBody GarbageBagDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addGarbageBag is start"));
            resultVo = orderFormService.addGarbageBag(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addGarbageBag is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "垃圾袋内新增货物接口", httpMethod = "POST")
    @RequestMapping(value = "/addOrderDetails", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> addOrderDetails(@RequestBody OrderDetailsDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addOrderDetails is start"));
            resultVo = orderDetailsService.addOrderDetails(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addOrderDetails is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "货物详情", httpMethod = "POST")
    @RequestMapping(value = "/listOrderDetails", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<BagCargoDto>> listOrderDetails(@RequestBody searchCargoDto dto) {
        ResultVo<List<BagCargoDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listOrderDetails is start"));
            resultVo = orderDetailsService.listOrderDetails(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("listOrderDetails is error", e.getMessage());
        }
        return resultVo;
    }
}
