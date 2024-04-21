package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 *  L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author lich
 * @date 2024/3/24
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode p = head, q = head;

        while (q.next != null) {
            p = p.next;
            q = q.next.next;
            if (q == null) {
                break;
            }
        }
        // p in the middle;

        q = reverse(p.next);

        p.next = null;

        // head and q交错
        ListNode p1 = head;
        ListNode p2 = q;

        boolean p1turn = true;

        while (p1 != null && p2 != null) {
            ListNode pp = p1turn ? p1 : p2;
            ListNode np = pp.next;
            pp.next = p1turn ? p2 : p1;
            if (p1turn) {
                p1 = np;
            } else {
                p2 = np;
            }
            p1turn = !p1turn;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy.next;

        ListNode q = p.next;

        while (q != null) {
            p.next = q.next;
            q.next = dummy.next;
            dummy.next = q;

            q = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReorderList r = new ReorderList();
        int[] nums = {1,2,3,4,5,6};
        ListNode head = Utils.init(nums);
        r.reorderList(head);

        Utils.print(head);
    }

}
