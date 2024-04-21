package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @author lich
 * @date 2024/1/23
 */
public class MaxPathSum {

    private static final int LEFT_PATH = 0;
    private static final int RIGHT_PATH = 1;
    private static final int CROSS_PATH = 2;

    private Map<TreeNode, int[]> xMaxPath = new HashMap<>();

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        xMaxPath.clear();
        maxPathSum = Integer.MIN_VALUE;

        helper(root, xMaxPath);
        return maxPathSum;
    }

    private void helper(TreeNode root, Map<TreeNode, int[]> xMaxPath) {
        if (root == null) {
            return;
        }

        xMaxPath.put(root, new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});

        int[] candidates = null;

        if (root.left != null) {
            helper(root.left, xMaxPath);
            candidates = new int[]{
                    root.val,
                    xMaxPath.get(root.left)[LEFT_PATH] + root.val,
                    xMaxPath.get(root.left)[RIGHT_PATH] + root.val,
            };
            xMaxPath.get(root)[LEFT_PATH] = Arrays.stream(candidates).max().getAsInt();
        } else {
            xMaxPath.get(root)[LEFT_PATH] = root.val;
        }

        if (root.right != null) {
            helper(root.right, xMaxPath);
            candidates = new int[]{
                    root.val,
                    xMaxPath.get(root.right)[LEFT_PATH] + root.val,
                    xMaxPath.get(root.right)[RIGHT_PATH] + root.val,
            };
            xMaxPath.get(root)[RIGHT_PATH] = Arrays.stream(candidates).max().getAsInt();
        } else {
            xMaxPath.get(root)[RIGHT_PATH] = root.val;
        }

        xMaxPath.get(root)[CROSS_PATH] = Arrays.stream(new int[]{
                root.val,
                xMaxPath.get(root)[LEFT_PATH] + xMaxPath.get(root)[RIGHT_PATH] - root.val
        }).max().getAsInt();

        maxPathSum = Math.max(Arrays.stream(xMaxPath.get(root)).max().getAsInt(), maxPathSum);
    }

    public static void main(String[] args) {
        MaxPathSum m = new MaxPathSum();
        Integer[] nums = {-10,9,20,null,null,15,7};
        TreeNode root = Utils.initTreeNode(nums);
        System.out.println(m.maxPathSum(root));
    }

}
