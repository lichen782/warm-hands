package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/1/18
 */

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode p = head;
        ListNode q = head.next;

        while (p != q && p != null && q != null) {
            p = p.next;
            q = q.next == null ? null : q.next.next;
        }
        return p != null && p == q;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        int[] nums = {3,2,0,-4};
        int pos = 3;
        ListNode listNode = Utils.initListNodeWithCycle(nums, pos);
        System.out.println(hasCycle.hasCycle(listNode));
    }
}
