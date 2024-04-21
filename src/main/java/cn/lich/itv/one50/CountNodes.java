package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * @author lich
 * @date 2024/1/24
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s = 0;
        if (root.left != null) {
            s += countNodes(root.left);
        }
        if (root.right != null) {
            s += countNodes(root.right);
        }

        return s + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6};
        TreeNode root = Utils.initTreeNode(nums);
        CountNodes c = new CountNodes();
        System.out.println(c.countNodes(root));
    }


}
