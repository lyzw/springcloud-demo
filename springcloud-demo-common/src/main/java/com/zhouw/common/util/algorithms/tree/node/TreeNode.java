package com.zhouw.common.util.algorithms.tree.node;

import com.zhouw.common.util.algorithms.Node;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/19.
 * @since v1.0
 */
public class TreeNode extends Node {
    //上级节点
    TreeNode topNode;

    public TreeNode getTopNode() {
        return topNode;
    }

    public void setTopNode(TreeNode topNode) {
        this.topNode = topNode;
    }

}
