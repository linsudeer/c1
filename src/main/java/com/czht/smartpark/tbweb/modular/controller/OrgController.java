package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.PermissonBean;
import com.czht.smartpark.tbweb.modular.dto.DeptDTO;
import com.czht.smartpark.tbweb.modular.service.OrgService;
import com.czht.smartpark.tbweb.modular.tree.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组织架构
 */
@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    /**
     * 获取包含在岗情况的部门树
     * @param pid
     * @return
     */
    @RequestMapping(value = "/onWorkTree", method = RequestMethod.GET)
    public Tip getOnWorkOrgTree(PermissonBean bean){
        List<TreeNode> tree = orgService.getOnWorkOrgTree(bean.getDeptPid());
        return ResultTip.success(tree);
    }

    /**
     * 获取包含在岗情况的部门树
     * @param pid
     * @return
     */
    @RequestMapping(value = "/onWorkList", method = RequestMethod.GET)
    public Tip getOnWorkOrg(PermissonBean bean){
        List<DeptDTO> list = orgService.getOnWorkOrg(bean.getDeptPid());
        return ResultTip.success(list);
    }
}
