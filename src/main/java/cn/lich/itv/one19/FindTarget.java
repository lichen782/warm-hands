package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 *
 * @author lich
 * @date 2024/4/8
 */
public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> left = new ArrayDeque<>();

        TreeNode p = root;

        while (p != null) {
            left.push(p);
            p = p.left;
        }

        Deque<TreeNode> right = new ArrayDeque<>();

        p = root;

        while (p != null) {
            right.push(p);
            p = p.right;
        }

        TreeNode l = left.pop();
        TreeNode r = right.pop();

        while (l != r) {
           int sum = l.val + r.val;
           if (sum == k) {
               return true;
           }

           if (sum < k) {
               // left moves
               l = l.right;
               while (l != null) {
                   left.push(l);
                   l = l.left;
               }
               l = left.pop();
           } else {
               r = r.left;
               while (r != null) {
                   right.push(r);
                   r = r.right;
               }
               r = right.pop();
           }
        }
        return false;
    }


    public static void main(String[] args) {
        FindTarget f = new FindTarget();
        Integer[] nums = {8,6,10,5,7,9,11};
        TreeNode root = Utils.initTreeNode(nums);

        System.out.println(f.findTarget(root, 22));
    }
}
