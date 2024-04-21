package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lich
 * @date 2024/1/27
 */
public class GetMinimumDifference {

    private List<Integer> values;

    public int getMinimumDifference(TreeNode root) {
        values = new ArrayList<>();
        helper(root);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < values.size(); i++) {
            minDiff = Integer.min(values.get(i) - values.get(i - 1), minDiff);
        }

        return minDiff;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            helper(root.left);
        }

        values.add(root.val);

        if (root.right != null) {
            helper(root.right);
        }

    }

    public static void main(String[] args) {
        GetMinimumDifference g = new GetMinimumDifference();
        Integer[] nums = {1,0,48,null,null,12,49};

        TreeNode root = Utils.initTreeNode(nums);
        System.out.println(g.getMinimumDifference(root));
    }

}
