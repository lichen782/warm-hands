package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/1/21
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        TreeNode leftReverted = invertTree(root.left);

        return isSameTree(leftReverted, root.right);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftReverted = invertTree(root.left);
        TreeNode rightReverted = invertTree(root.right);

        root.left = rightReverted;
        root.right = leftReverted;

        return root;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) ||
                (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        Integer[] nums = {5,4,1,null,1,null,4,2,null,2,null};
        TreeNode root = Utils.initTreeNode(nums);
        IsSymmetric i = new IsSymmetric();
        System.out.print(i.isSymmetric(root));
    }

}
