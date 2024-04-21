package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *
 *
 * 示例1：
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 *           1
 *          / \
 *         2   3
 * 示例3：
 *
 * 输入: root = [1]
 * 输出: [1]
 * 示例4：
 *
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 *            1
 *             \
 *              2
 * 示例5：
 *
 * 输入: root = []
 * 输出: []
 *
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 * @author lich
 * @date 2024/4/4
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        TreeNode first = root;

        List<Integer> ans = new ArrayList<>();

        int max = root.val;

        while (!q.isEmpty()) {
           TreeNode n = q.pop();
           if (n == first) {
               ans.add(max);
               // 新的一行
               first = null;
               max = Integer.MIN_VALUE;
           }

           if (n.left != null) {
               max = Math.max(max, n.left.val);
               q.add(n.left);
               if (first == null) {
                   first = n.left;
               }
           }

           if (n.right != null) {
               max = Math.max(max, n.right.val);
               q.add(n.right);
               if (first == null) {
                   first = n.right;
               }
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestValues l = new LargestValues();
        Integer[] nums = {1,null,2};
        TreeNode root = Utils.initTreeNode(nums);
        List<Integer> ans = l.largestValues(root);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
