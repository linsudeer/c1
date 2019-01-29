package com.czht.smartpark.tbweb.modular.tree;

import com.czht.smartpark.tbweb.modular.dto.DeptDTO;
import com.czht.smartpark.tbweb.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TreeUtil {

        /**
         * 转换组织列表为树节点
         * @param orgs
         * @return
         */
    public static List<TreeNode> treeWrap(List<DeptDTO> orgs) {
        List<TreeNode> roots = new ArrayList<TreeNode>();

        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(orgs != null && orgs.size()>0){
            // 转换组织结构为树结构
            for(DeptDTO org: orgs) {
                TreeNode node = new TreeNode();
                node.setId(org.getDeptId());
                node.setText(org.getDeptName());
                node.setpId(org.getParentId());
                node.setType(org.getType());
                if(org.getOnWorkCnt() != null){
                    node.setTags(new String[]{org.getOnWorkCnt()+""});
                }
                TreeState state = new TreeState();
                state.setSelected(false);
                node.setState(state);
                nodes.add(node);
            }
            // 将所有节点组装成一颗树
            List<TreeNode> cnodes = new ArrayList<TreeNode>();
            cnodes.addAll(nodes);
            roots = assblyTree(nodes, cnodes);

        }
        return roots;
    }

    private static List<TreeNode> assblyTree(List<TreeNode> nodes, List<TreeNode> cnodes){
        TreeNode root = new TreeNode();
        List<TreeNode> removeNodes = new ArrayList<TreeNode>();
        for(TreeNode pnode: nodes) {
            List<TreeNode> childrens = new ArrayList<TreeNode>();

            ListIterator<TreeNode> it = cnodes.listIterator();
            while(it.hasNext()){
                TreeNode cnode = it.next();
                if(cnode.getpId()!=null && cnode.getpId().equals(pnode.getId())){
                    childrens.add(cnode);
                    pnode.setTags(new String[]{(Integer.parseInt(pnode.getTags()[0])+Integer.parseInt(cnode.getTags()[0]))+""});
                    removeNodes.add(cnode);
                }
            }
            if(childrens.size()>0){
                pnode.setNodes(childrens);
            }

        }

        if(removeNodes.size()>0){
            nodes.removeAll(removeNodes);
            for(TreeNode node : nodes) {
                if(node.getNodes() != null){
                    assblyTree(node.getNodes(), cnodes);
                }

            }

        }

        return nodes;
    }


    public static void main(String[] args) {
        List<DeptDTO> orgs = new ArrayList<DeptDTO>();
        orgs.add(new DeptDTO(1,0, "北京诚志重"));
        orgs.add(new DeptDTO(2,0, "硬件部"));
        orgs.add(new DeptDTO(3,1, "软件部"));
        orgs.add(new DeptDTO(4,1, "综合部"));
        orgs.add(new DeptDTO(5,2, "办公室"));
        orgs.add(new DeptDTO(6,2, "测试组"));

        List<TreeNode> tree = treeWrap(orgs);

        System.out.println(JsonUtil.toJsonString(tree));

    }
}
