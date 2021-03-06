package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.PermissonBean;
import com.czht.smartpark.tbweb.modular.dto.CodeDTO;
import com.czht.smartpark.tbweb.modular.service.CodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @RequestMapping("/user")
    public Tip getUsers(String key, String deptId, Integer limit) {
        List<CodeDTO> codes = codeService.getUsers(key, deptId, limit);
        return ResultTip.success(codes);
    }

    @RequestMapping("/area")
    public Tip getAreas(String key, Integer limit) {
        List<CodeDTO> codes = codeService.getAreas(key, limit);
        return ResultTip.success(codes);
    }

    @RequestMapping("/dept")
    public Tip getDepts(String key, Integer limit) {
        PermissonBean bean = new PermissonBean();
        List<CodeDTO> codes = codeService.getDepts(key, bean.getDeptPid(), limit);
        return ResultTip.success(codes);
    }

    @RequestMapping("/{key}")
    public Tip getDicts(@PathVariable("key") String key) {
        List<CodeDTO> codes = codeService.getDicts(key);
        return ResultTip.success(codes);
    }
}
