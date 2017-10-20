package com.zhouw.common.util.algorithms.tree.node;

import java.util.List;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/19.
 * @since v1.0
 */
public class NormalTreeNode extends TreeNode{

    List<NormalTreeNode>  childNodes;

    public List<NormalTreeNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<NormalTreeNode> childNodes) {
        this.childNodes = childNodes;
    }
}
