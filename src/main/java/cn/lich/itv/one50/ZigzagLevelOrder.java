package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lich
 * @date 2024/1/26
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode starter = root;
        boolean pendingStarter = false;
        boolean left2right = true;

        while (!q.isEmpty()) {
            TreeNode node = q.peek();
            if (node == starter) {
                pendingStarter = true;
                result.add(buildList(q, left2right));
                left2right = !left2right;
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

    private List<Integer> buildList(LinkedList<TreeNode> treeNodes, boolean reverse) {
        List<Integer> result = new ArrayList<>(treeNodes.size());
        Iterator<TreeNode> iterator = reverse ? treeNodes.iterator() : treeNodes.descendingIterator();
        while (iterator.hasNext()) {
            result.add(iterator.next().val);
        }

        return result;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder z = new ZigzagLevelOrder();
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = Utils.initTreeNode(nums);

        List<List<Integer>> l = z.zigzagLevelOrder(root);
        for (List<Integer> ll: l) {
            for(Integer i : ll) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
