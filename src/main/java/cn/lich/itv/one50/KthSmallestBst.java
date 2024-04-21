package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.function.Function;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @author lich
 * @date 2023/8/27
 */
public class KthSmallestBst {

    public int kthSmallest(TreeNode root, int k) {
        int[] result = {0, Integer.MIN_VALUE};
        traverseMid(root, n -> {
           if (++result[0] == k) {
               result[1] = n.val;
               return false;
           }
           return true;
        });

        return result[1];
    }

    public static void traverseMid(TreeNode root, Function<TreeNode, Boolean> onNode) {
        if (root.left != null) {
            traverseMid(root.left, onNode);
        }

        boolean goon = onNode.apply(root);
        if (!goon) {
            return;
        }

        if (root.right != null) {
            traverseMid(root.right, onNode);
        }
    }

    public static void main(String[] args) {
        TreeNode root = Utils.initTreeNode(new Integer[] {3,1,4,null,2});
        traverseMid(root, n -> {
            System.out.print(n.val + " ");
            return true;
        });

        KthSmallestBst s = new KthSmallestBst();

        int k = 3;
        System.out.println(String.format("\nk: %s kth: %s", k, s.kthSmallest(root, k)));
    }

}
