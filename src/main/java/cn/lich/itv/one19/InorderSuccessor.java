package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 *
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2：
 *
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 * @author lich
 * @date 2024/4/7
 */
public class InorderSuccessor {

    private TreeNode pre;
    private TreeNode ans;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (p.right != null) {
            TreeNode q = p.right;
            while (q.left != null) {
                q = q.left;
            }
            return q;
        }

        inorder(root, p);
        return ans;
    }

    private void inorder(TreeNode root, TreeNode target) {

        if (root.left != null) {
            inorder(root.left, target);
        }

        //visit root
        if (pre == target) {
            if (ans == null) {
                ans = root;
            }
            return;
        } else {
            pre = root;
        }

        if (root.right != null) {
            inorder(root.right, target);
        }

    }

    public static void main(String[] args) {
        InorderSuccessor i = new InorderSuccessor();
        Integer[] nums = {5,3,6,2,4,null,null,1};
        TreeNode root = Utils.initTreeNode(nums);

        TreeNode target = Utils.findTreeNodeWithVal(root, 1);

        TreeNode successor = i.inorderSuccessor(root, target);
        System.out.println(successor != null ? successor.val: "null");
    }
}
