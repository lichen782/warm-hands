package cn.lich.itv.one50;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/1/21
 */
public class SameTreeCheck {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (p == null && q == null) ||
                (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {
        Integer[] n1 = {1, 2};
        Integer[] n2 = {1, null, 2};
        TreeNode p = Utils.initTreeNode(n1);
        TreeNode q = Utils.initTreeNode(n2);

        SameTreeCheck stc = new SameTreeCheck();

        System.out.println(stc.isSameTree(p, q));
    }
}
