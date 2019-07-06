package com.xlkj.website.controller;

import com.xlkj.website.model.SearchEquDto;
import com.xlkj.website.model.EquipmentDto;
import com.xlkj.website.model.ResultVo;
import com.xlkj.website.service.EquipmentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Description: 设备管理
 */
@RestController
@RequestMapping(value = "/equipment")
@CrossOrigin
public class EquipmentController{
    @Autowired
    private EquipmentService equipmentService;

    private Logger logger = LoggerFactory.getLogger(OrderFormController.class);

    @ApiOperation(value = "设备新增接口", httpMethod = "POST")
    @RequestMapping(value = "/addEquipment", method = RequestMethod.POST)
    public ResultVo<Integer> addEquipment(@RequestBody EquipmentDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("addEquipment is start"));
            resultVo = equipmentService.addEquipment(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("addEquipment is error", e.getMessage());
        }
        return resultVo;
    }


    @ApiOperation(value = "设备修改接口", httpMethod = "POST")
    @RequestMapping(value = "/modifyEquipment", method = RequestMethod.POST)
    public ResultVo<Integer> modifyEquipment(@RequestBody EquipmentDto dto) {
        ResultVo<Integer> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("modifyEquipment is start"));
            resultVo = equipmentService.modifyEquipment(dto);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("modifyEquipment is error", e.getMessage());
        }
        return resultVo;
    }

    @ApiOperation(value = "设备列表接口", httpMethod = "POST")
    @RequestMapping(value = "/listEquipment", method = RequestMethod.POST)
    public ResultVo<EquipmentDto> listEquipment(@RequestBody SearchEquDto com) {
        ResultVo<EquipmentDto> resultVo = new ResultVo<>();
        try {
            logger.info(String.format("listEquipment is start"));
            resultVo = equipmentService.listEquipment(com);
        } catch (Exception e) {
            resultVo.resultFail("系统异常" + e.getMessage());
            logger.error("listEquipment is error", e.getMessage());
        }
        return resultVo;
    }
}
