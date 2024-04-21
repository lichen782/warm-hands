package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 *
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 * @author lich
 * @date 2024/4/8
 */
public class ConvertBST {

    private TreeNode successor;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        post(root);

        return root;
    }

    private void post(TreeNode root) {
        assert root != null;

        if (root.right != null) {
            post(root.right);
        }

        if (successor != null) {
            root.val += successor.val;
        }

        successor = root;

        if (root.left != null) {
            post(root.left);
        }

    }

    public static void main(String[] args) {
        ConvertBST c = new ConvertBST();
        Integer[] nums = {3,2,4,1};
        TreeNode root = Utils.initTreeNode(nums);

        c.convertBST(root);

        Utils.print(root);
    }
}
