package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * @author lich
 * @date 2024/1/22
 */
public class BuildTreePostIn {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderPos.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        for (int i = postorder.length - 2; i >= 0; i--) {
            int inOrderOfMe = inorderPos.get(postorder[i]);
            TreeNode rootForMe = stack.peek();

            if (inorderPos.get(rootForMe.val) < inOrderOfMe) {
                rootForMe.right = new TreeNode(postorder[i]);
                stack.push(rootForMe.right);
                continue;
            }

            while(!stack.isEmpty() && inorderPos.get(stack.peek().val) > inOrderOfMe) {
                rootForMe = stack.pop();
            }

            rootForMe.left = new TreeNode(postorder[i]);
            stack.push(rootForMe.left);
        }

        return root;
    }

    public static void main(String[] args) {
        BuildTreePostIn b = new BuildTreePostIn();
        int[] preorder = {9,3,15,20,7};
        int[] inorder = {9,15,7,20,3};

        TreeNode root = b.buildTree(preorder, inorder);

        Utils.print(root);
    }
}
