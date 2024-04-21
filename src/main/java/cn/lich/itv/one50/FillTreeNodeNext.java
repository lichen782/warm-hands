package cn.lich.itv.one50;

import cn.lich.itv.utils.tree.Node;
import cn.lich.itv.utils.Utils;

import java.util.LinkedList;

/**
 * 给定一个二叉树：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 *
 * @author lich
 * @date 2024/1/22
 */
public class FillTreeNodeNext {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        Node lastLevel = root;
        boolean pendingLevelStarter = false;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (lastLevel == cur) {
                pendingLevelStarter = true;
                Node last = cur;
                for (Node current : q) {
                    last.next = current;
                    last = current;
                }
            }

            if (cur.left != null) {
                q.add(cur.left);
                if (pendingLevelStarter) {
                    pendingLevelStarter = false;
                    lastLevel = cur.left;
                }
            }

            if (cur.right != null) {
                q.add(cur.right);
                if (pendingLevelStarter) {
                    pendingLevelStarter = false;
                    lastLevel = cur.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        FillTreeNodeNext f = new FillTreeNodeNext();
        Integer[] nums = {1,2,3,4,5,null,7};
        Node root = Utils.initNextTreeNode(nums);
        Utils.print(root);
        System.out.println();
        f.connect(root);
        Utils.print(root);
    }

}
