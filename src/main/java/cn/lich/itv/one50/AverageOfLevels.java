package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lich
 * @date 2024/1/26
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Double> result = new ArrayList<>();

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode starter = root;
        Boolean pendingStarter = false;

        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            if (node == starter) {
                pendingStarter = true;
                result.add(average(q));
            }

            q.poll();

            if (node.left != null) {
                q.add(node.left);
                if (pendingStarter) {
                    starter = node.left;
                    pendingStarter = false;
                }
            }

            if (node.right != null) {
                q.add(node.right);
                if (pendingStarter) {
                    starter = node.right;
                    pendingStarter = false;
                }
            }
        }

        return result;
    }

    private double average(LinkedList<TreeNode> l) {
        long sum = l.stream().map(n -> Long.valueOf(n.val)).reduce(Long::sum).get();
        return Double.valueOf(sum / (double)l.size());
    }

    public static void main(String[] args) {
        AverageOfLevels a = new AverageOfLevels();
        Integer[] nums = {3,9,20,null,null,15,7};

        TreeNode root =Utils.initTreeNode(nums);

        List<Double> l = a.averageOfLevels(root);

        for (Double d: l) {
            System.out.print(d + ",");
        }
    }
}
