package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * @author lich
 * @date 2024/4/6
 */
public class MaxPathSum {

    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;

        maxPathSumFrom(root);

        return ans;
    }

    private int maxPathSumFrom(TreeNode root) {

        List<Integer> candidates = new ArrayList<>();

        candidates.add(root.val);

        int leftMax = 0, rightMax = 0;

        if (root.left != null) {
            leftMax = maxPathSumFrom(root.left);
            candidates.add(leftMax + root.val);
        }

        if (root.right != null) {
            rightMax = maxPathSumFrom(root.right);
            candidates.add(rightMax + root.val);
        }

        candidates.add(leftMax + rightMax + root.val);
        candidates.add(ans);

        ans = Collections.max(candidates);

        return Math.max(root.val, Math.max(leftMax + root.val, rightMax + root.val));
    }

    public static void main(String[] args) {
        MaxPathSum m = new MaxPathSum();

        Integer[] nums = {-3};

        TreeNode root = Utils.initTreeNode(nums);

        System.out.println(m.maxPathSum(root));
    }

}
