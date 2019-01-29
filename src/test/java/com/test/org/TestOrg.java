package com.test.org;

import com.czht.smartpark.tbweb.modular.service.OrgService;
import com.czht.smartpark.tbweb.modular.tree.TreeNode;
import com.czht.smartpark.tbweb.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-core.xml","classpath*:spring-dao-smart.xml"})
public class TestOrg {

    @Autowired
    private OrgService orgService;

    @Test
    public void testOrgOnWorkTree(){
        List<TreeNode> tree = orgService.getOnWorkOrgTree(0);

        System.out.println(JsonUtil.toJsonString(tree));
    }
}
