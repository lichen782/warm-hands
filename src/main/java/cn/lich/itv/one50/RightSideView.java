package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author lich
 * @date 2024/1/26
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode starter = root;
        Boolean pendingStarter = false;

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == starter) {
                pendingStarter = true;
                if (node == root) {
                    result.add(root.val);
                } else {
                    result.add(q.isEmpty() ? node.val : q.peekLast().val);
                }
            }

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
        RightSideView r = new RightSideView();

        Integer[] nums = {1,3};

        TreeNode root = Utils.initTreeNode(nums);

        List<Integer> l = r.rightSideView(root);
        l.forEach(i -> System.out.print(i + ","));
    }
}
