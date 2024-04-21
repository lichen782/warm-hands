package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 *
 * @author lich
 * @date 2024/1/23
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        List<String> all = sumNumbersFrom(root);
        int s = 0;
        for (String ps: all) {
            s += Integer.valueOf(ps);
        }
        return s;
    }

    private List<String> sumNumbersFrom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> leftSums = sumNumbersFrom(root.left);
        List<String> rightSums = sumNumbersFrom(root.right);

        List<String> l = new ArrayList<>();
        l.addAll(leftSums);
        l.addAll(rightSums);

        if (l.size() == 0) {
            l.add(String.valueOf(root.val));
            return l;
        }

        for (int i = 0; i < l.size(); i++) {
            int high = root.val;
            l.set(i, high + l.get(i));
        }

        return l;
    }

    public static void main(String[] args) {
        SumNumbers s = new SumNumbers();

        Integer[] sums = {5,3,2,7,0,6,null,null,null,0};

        TreeNode root = Utils.initTreeNode(sums);
        System.out.println(s.sumNumbers(root));
    }
}
