package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 *
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 *
 *
 * 示例 1：
 *
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 *
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 *
 *
 * 提示：
 *
 * 最初给定的树是完全二叉树，且包含 1 到 1000 个节点。
 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
 * 给定节点或插入节点的每个值都在 0 到 5000 之间。
 *
 * @author lich
 * @date 2024/4/4
 */
public class CBTInserter {

    private TreeNode root;

    private Deque<TreeNode> q;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.peek();
            if (n.left != null) {
                q.add(n.left);
            }

            if (n.right != null) {
                q.add(n.right);
            }
            if (n.left == null || n.right == null) {
                break;
            } else {
                q.poll();
            }

        }
    }

    public int insert(int v) {
        TreeNode n = new TreeNode();
        n.val = v;
        TreeNode pre = q.peek();
        if (pre.left == null) {
            pre.left = n;
        } else {
            pre.right = n;
            q.poll();
        }
        q.add(n);
        return pre.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        Integer[] tree = {1,2,3,4,5,6};
        TreeNode root = Utils.initTreeNode(tree);
        Utils.print(root);
        System.out.println();
        CBTInserter cbtInserter = new CBTInserter(root);
        System.out.println(cbtInserter.insert(7));
        System.out.println(cbtInserter.insert(8));

        root = cbtInserter.get_root();
        Utils.print(root);
    }
}
