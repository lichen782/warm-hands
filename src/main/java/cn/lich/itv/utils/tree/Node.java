package cn.lich.itv.utils.tree;

import cn.lich.itv.utils.TreeNode;

/**
 * @author lich
 * @date 2024/1/22
 */
public class Node extends TreeNode {

    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
