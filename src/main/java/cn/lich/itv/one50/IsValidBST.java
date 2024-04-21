package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author lich
 * @date 2024/1/27
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root) != null;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        }

        int[] minAndMax = {root.val, root.val};

        if (root.left != null) {
            int[] minAndMaxFromLeft = helper(root.left);
            if (minAndMaxFromLeft == null || minAndMaxFromLeft[1] >= root.val) {
                return null;
            }
            minAndMax[0] = minAndMaxFromLeft[0];
        } else {
            minAndMax[0] = root.val;
        }

        if (root.right != null) {
            int[] minAndMaxFromRight = helper(root.right);
            if (minAndMaxFromRight == null || minAndMaxFromRight[0] <= root.val) {
                return null;
            }
            minAndMax[1] = minAndMaxFromRight[1];
        } else {
            minAndMax[1] = root.val;
        }


        return minAndMax;
    }


    public static void main(String[] args) {
        IsValidBST i = new IsValidBST();
        Integer[] nums = {2,1,3};
        TreeNode root = Utils.initTreeNode(nums);

        System.out.println(i.isValidBST(root));
    }
}
