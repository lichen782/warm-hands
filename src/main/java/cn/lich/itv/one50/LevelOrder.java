package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lich
 * @date 2024/1/26
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode starter = root;
        Boolean pendingStarter = false;

        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            if (node == starter) {
                pendingStarter = true;
                result.add(q.stream().map(n -> n.val).collect(Collectors.toList()));
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

    public static void main(String[] args) {
        LevelOrder level = new LevelOrder();
        Integer[] nums = {1};
        TreeNode root = Utils.initTreeNode(nums);
        List<List<Integer>> l = level.levelOrder(root);
        for (List<Integer> ll: l) {
            for(Integer i : ll) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
