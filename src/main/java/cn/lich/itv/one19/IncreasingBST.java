package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * @author lich
 * @date 2024/4/6
 */
public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        return moving(root);
    }

    private TreeNode moving(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            root.right = moving(root.right);
        }

        if (root.left != null) {
            TreeNode head = moving(root.left);
            TreeNode q = head;
            while (q.right != null) {
                q = q.right;
            }
            q.right = root;
            root.left = null;
            return head;
        }

        return root;
    }

    public static void main(String[] args) {
        IncreasingBST i = new IncreasingBST();
        Integer[] nums = {5,1,7};
        TreeNode root = Utils.initTreeNode(nums);
        root = i.increasingBST(root);

        Utils.print(root);
    }
}
