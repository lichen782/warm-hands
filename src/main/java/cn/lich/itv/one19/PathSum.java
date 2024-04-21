package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 *
 * @author lich
 * @date 2024/4/6
 */
public class PathSum {

    private int ans;

    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.ans = 0;
        this.targetSum = targetSum;

        dfs(root);

        return ans;
    }

    // using prefix sum
    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0l, 1);
        return dfs2(root, 0, prefixSumMap, targetSum);
    }

    private int dfs2(TreeNode root, long totalSumSoFar, Map<Long, Integer> prefixSumMap, int targetSum) {
        if (root == null) {
            return 0;
        }

        totalSumSoFar += root.val;

        int ret = prefixSumMap.getOrDefault(totalSumSoFar - targetSum, 0);

        prefixSumMap.put(totalSumSoFar, prefixSumMap.getOrDefault(totalSumSoFar, 0) + 1);

        int left = dfs2(root.left, totalSumSoFar, prefixSumMap, targetSum);
        int right = dfs2(root.right, totalSumSoFar, prefixSumMap, targetSum);

        ret += left + right;
        prefixSumMap.put(totalSumSoFar, prefixSumMap.getOrDefault(totalSumSoFar, 0) - 1);


        return ret;
    }

    private void dfs(TreeNode root) {

        pathSumFromRoot(root, targetSum);

        if (root.left != null) {
            dfs(root.left);
        }

        if (root.right != null) {
            dfs(root.right);
        }
    }

    private void pathSumFromRoot(TreeNode root, long target) {
        if (root == null) {
            return;
        }

        if (target == root.val) {
            ans++;
        }

        if (root.left != null) {
            pathSumFromRoot(root.left, target - root.val);
        }
        if (root.right != null) {
            pathSumFromRoot(root.right, target - root.val);
        }
    }


    public static void main(String[] args) {
        PathSum ps = new PathSum();

        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = Utils.initTreeNode(nums);

        System.out.println(ps.pathSum2(root, 8));
    }
}
