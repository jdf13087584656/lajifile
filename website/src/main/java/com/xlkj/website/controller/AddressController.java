package com.xlkj.website.controller;

import com.xlkj.website.model.EquipmentDto;
import com.xlkj.website.model.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @Description: 省市区
 */
@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class AddressController {

    private Logger logger = LoggerFactory.getLogger(OrderFormController.class);

    @ApiOperation(value = "查询省接口", httpMethod = "POST")
    @RequestMapping(value = "/province", method = RequestMethod.POST)
    public ResultVo<Integer> province() {
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
}
