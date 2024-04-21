package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author lich
 * @date 2024/1/22
 */
public class FlattenTree {

    public void flatten(TreeNode root) {
        flattenAndReturnLast(root);
    }

    private TreeNode flattenAndReturnLast(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode left = root.left;
        TreeNode leftLast = flattenAndReturnLast(root.left);

        root.left = null;

        TreeNode right = root.right;
        TreeNode rightLast = flattenAndReturnLast(root.right);

        if (left != null) {
            root.right = left;
        }
        if (leftLast != null) {
            leftLast.right = right;
        }

        if (leftLast == null && rightLast == null) {
            return root;
        }

        return rightLast != null ? rightLast : leftLast;
    }

    public static void main(String[] args) {
        FlattenTree f = new FlattenTree();
        Integer[] nums = {1,2,5,3,4,null,6};
        TreeNode root = Utils.initTreeNode(nums);
        f.flatten(root);

        Utils.print(root);
    }
}
