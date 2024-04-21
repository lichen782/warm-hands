package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/1/21
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftReverted = invertTree(root.left);
        TreeNode rightReverted = invertTree(root.right);

        root.left = rightReverted;
        root.right = leftReverted;

        return root;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        Integer[] tree = {4,2,7,1,3,6,9};

        TreeNode root = Utils.initTreeNode(tree);
        root = invertTree.invertTree(root);

        Utils.print(root);
    }

}
