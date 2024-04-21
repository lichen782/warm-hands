package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * @author lich
 * @date 2024/4/5
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        TreeNode first = root;
        TreeNode candidate = null;
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == first) {
                // this level has been traversed;
                candidate = first;
                first = null;
            }

            if (n.left != null) {
                q.add(n.left);
                if (first == null) {
                    first = n.left;
                }
            }

            if (n.right != null) {
                q.add(n.right);
                if (first == null) {
                    first = n.right;
                }
            }
        }

        return candidate.val;
    }

    public static void main(String[] args) {
        FindBottomLeftValue f = new FindBottomLeftValue();
        Integer[] nums = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = Utils.initTreeNode(nums);
        int ans = f.findBottomLeftValue(root);
        System.out.println(ans);
    }
}
