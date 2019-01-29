package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.dmo.Area;
import com.czht.smartpark.tbweb.modular.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    /**
     * 查找所有区域
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Tip getAreas() {
        List<Area> areas = areaService.getAreas();
        return ResultTip.success(areas);
    }
}
