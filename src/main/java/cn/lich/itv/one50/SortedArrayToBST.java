package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @author lich
 * @date 2024/2/6
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayRange(nums, 0, nums.length);
    }

    private TreeNode sortedArrayRange(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayRange(nums, start, mid);
        root.right = sortedArrayRange(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST s = new SortedArrayToBST();
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = s.sortedArrayToBST(nums);
        Utils.print(root);
    }
}
