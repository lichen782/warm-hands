package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * @author lich
 * @date 2024/1/21
 */
public class BuildTreePreIn {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderPos.put(inorder[i], i);
        }

        TreeNode root = new TreeNode(preorder[0]);
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            int inOrderOfMe = inorderPos.get(preorder[i]);
            TreeNode rootForMe = stack.peek();

            if (inorderPos.get(rootForMe.val) > inOrderOfMe) {
                rootForMe.left = new TreeNode(preorder[i]);
                stack.push(rootForMe.left);
                continue;
            }

            while(!stack.isEmpty() && inorderPos.get(stack.peek().val) < inOrderOfMe) {
                rootForMe = stack.pop();
            }

            rootForMe.right = new TreeNode(preorder[i]);
            stack.push(rootForMe.right);

        }

        return root;
    }

    public static void main(String[] args) {
        BuildTreePreIn b = new BuildTreePreIn();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = b.buildTree(preorder, inorder);

        Utils.print(root);
    }

}
