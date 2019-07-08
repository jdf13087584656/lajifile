package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.*;
import com.xlkj.website.service.CargoService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Description: 货物
 */
@RestController
@RequestMapping(value = "/cargo")
@CrossOrigin
public class CargoController {
    private Logger logger = LoggerFactory.getLogger(CargoController.class);

    @Autowired
    private CargoService cargoService;

    @ApiOperation(value = "货物基础信息新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addCargo", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> addCargo(@RequestBody CargoDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addCargo is start"));
            resultVo = cargoService.addCargo(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addCargo is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "货物基础信息修改接口", httpMethod = "POST")
    @RequestMapping(value = "/modifyCargo", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> modifyCargo(@RequestBody CargoDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyCargo is start"));
            resultVo = cargoService.modifyCargo(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("modifyCargo is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "货物基础信息列表接口", httpMethod = "POST")
    @RequestMapping(value = "/listCargo", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<CargoDto>> listCargo() {
        ResultVo<List<CargoDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listCargo is start"));
            resultVo = cargoService.listCargo();
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("listCargo is error", e.getMessage());
        }
        return resultVo;
    }



}
