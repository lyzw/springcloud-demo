package com.zhouw.common.util.algorithms.tree.node;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/19.
 * @since v1.0
 */
public class BinaryTreeNode extends TreeNode {

    //左节点
    BinaryTreeNode lefeNode;
    //右节点
    BinaryTreeNode rightNode;

    public BinaryTreeNode getLefeNode() {
        return lefeNode;
    }

    public void setLefeNode(BinaryTreeNode lefeNode) {
        this.lefeNode = lefeNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

}
