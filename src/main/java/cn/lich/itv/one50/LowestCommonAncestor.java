package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.LinkedList;

/**
 *给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 * @author lich
 * @date 2024/1/25
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> parentLinksFromP = traverseBuildLinksFrom(root, p);
        LinkedList<TreeNode> parentLinksFromQ = traverseBuildLinksFrom(root, q);

        TreeNode commonRoot = root;

        while (!parentLinksFromP.isEmpty() && !parentLinksFromQ.isEmpty()) {
            TreeNode pp = parentLinksFromP.pollLast();
            TreeNode qq = parentLinksFromQ.pollLast();
            if (!pp.equals(qq)) {
                break;
            } else {
                commonRoot = pp;
            }
        }

        return commonRoot;
    }

    private LinkedList<TreeNode> traverseBuildLinksFrom(TreeNode root, TreeNode p) {

        LinkedList<TreeNode> parentLinks;

        if (root.equals(p)) {
            parentLinks = new LinkedList<>();
            parentLinks.add(p);
            return parentLinks;
        }

        if (root.left != null) {
            parentLinks = traverseBuildLinksFrom(root.left, p);
            if (parentLinks !=  null) {
                parentLinks.add(root);
                return parentLinks;
            }
        }

        if (root.right != null) {
            parentLinks = traverseBuildLinksFrom(root.right, p);
            if (parentLinks !=  null) {
                parentLinks.add(root);
                return parentLinks;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();

        Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root =Utils.initTreeNode(nums);

        TreeNode commonRoot = l.lowestCommonAncestor(root, new TreeNode(4), new TreeNode(5));

        System.out.println(commonRoot.val);

    }
}
