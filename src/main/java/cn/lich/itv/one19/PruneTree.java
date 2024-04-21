package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 *
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 *
 * 示例 2:
 *
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * 解释:
 *
 *
 * 示例 3:
 *
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 * 解释:
 *
 *
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [1,200]
 * 二叉树节点的值只会是 0 或 1
 * @author lich
 * @date 2024/4/6
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        assert root.val == 0 || root.val == 1;

        // if leaf, return based on prune or not
        if (root.left == null && root.right == null) {
            return root.val == 1 ? root : null;
        }

       root.left = pruneTree(root.left);
       root.right = pruneTree(root.right);

       return root.val == 1 ? root : (root.left == null && root.right == null ? null : root);

    }

    public static void main(String[] args) {
        PruneTree pt = new PruneTree();
        Integer[] nums = {1,1,0,1,1,0,1,0};

        TreeNode root = Utils.initTreeNode(nums);

        root = pt.pruneTree(root);

        Utils.print(root);
    }
}
