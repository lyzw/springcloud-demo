package com.zhouw.common.util.algorithms.tree;

import com.zhouw.common.util.algorithms.tree.node.TreeNode;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/19.
 * @since v1.0
 */
public class Tree<T extends TreeNode> {

    //根节点
    T root;

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }
}
