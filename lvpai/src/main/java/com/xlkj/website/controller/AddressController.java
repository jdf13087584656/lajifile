package com.xlkj.website.controller;

import com.xlkj.website.annotation.AuthPass;
import com.xlkj.website.model.AddAddress;
import com.xlkj.website.model.AddressDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.model.SearchAddressDto;
import com.xlkj.website.service.SearchAddressService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @Description: 省市区
 */
@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class AddressController {

    private Logger logger = LoggerFactory.getLogger(OrderFormController.class);
    @Autowired
    private SearchAddressService searchAddressService;

    @ApiOperation(value = "查询省接口", httpMethod = "POST")
    @RequestMapping(value = "/province", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<AddressDto>> province(@RequestBody AddressDto dto) {
        ResultVo<List<AddressDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("province is start"));
            resultVo = searchAddressService.searchProvince(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("province is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "查询市接口", httpMethod = "POST")
    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<AddressDto>> city(@RequestBody AddressDto dto) {
        ResultVo<List<AddressDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("city is start"));
            resultVo = searchAddressService.searchCity(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("city is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "查询县区接口", httpMethod = "POST")
    @RequestMapping(value = "/area", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<AddressDto>> area(@RequestBody AddressDto dto) {
        ResultVo<List<AddressDto>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("area is start"));
            resultVo = searchAddressService.searchArea(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("area is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "地址新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> addAddress(@RequestBody AddAddress add) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addAddress is start"));
            resultVo = searchAddressService.addAddress(add);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addAddress is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "地址修改接口", httpMethod = "POST")
    @RequestMapping(value = "/modifyAddress", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<Integer> modifyAddress(@RequestBody AddAddress add) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyAddress is start"));
            resultVo = searchAddressService.modifyAddress(add);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("modifyAddress is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "地址列表接口", httpMethod = "POST")
    @RequestMapping(value = "/listAddress", method = RequestMethod.POST)
    @AuthPass
    public ResultVo<List<AddAddress>> listAddress(@RequestBody SearchAddressDto dto) {
        ResultVo<List<AddAddress>> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listAddress is start"));
            resultVo = searchAddressService.listAddress(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("listAddress is error", e.getMessage());
        }
        return resultVo;
    }
}
