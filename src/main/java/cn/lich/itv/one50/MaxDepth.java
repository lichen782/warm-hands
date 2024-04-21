package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.LinkedList;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author lich
 * @date 2024/1/21
 */
public class MaxDepth {

    class TreeNodeWithDepth {

        TreeNode node;

        int depth;

        boolean leftPass;

        boolean rightPass;

        public String toString() {
            return String.format(
                    "node.val=%s, depth=%s, leftPass=%s, rightPass=%s",
                    node.val, depth, leftPass, rightPass);
        }

        TreeNodeWithDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNodeWithDepth> stack = new LinkedList<>();

        int maxDepth = 1;

        stack.push(new TreeNodeWithDepth(root, 1));

        while (!stack.isEmpty()) {

            TreeNodeWithDepth depthNode = stack.peek();

            if (depthNode.leftPass && depthNode.rightPass) {
                stack.pop();
                continue;
            }

            if (!depthNode.leftPass) {
                depthNode.leftPass = true;
                while (depthNode.node.left != null) {
                    depthNode = new TreeNodeWithDepth(depthNode.node.left, depthNode.depth + 1);
                    depthNode.leftPass = true;
                    stack.push(depthNode);
                }
            }

            if (depthNode.node.right == null) {
                // leaf
                maxDepth = Math.max(depthNode.depth, maxDepth);
                stack.pop();
            } else if (!depthNode.rightPass){
                depthNode.rightPass = true;
                stack.push(new TreeNodeWithDepth(depthNode.node.right, depthNode.depth + 1));
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        MaxDepth m = new MaxDepth();
        Integer[] nums = {1,null,2};
        TreeNode root = Utils.initTreeNode(nums);

        System.out.println(m.maxDepth(root));
    }
}
