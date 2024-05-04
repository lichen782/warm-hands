package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * @author lich
 * @date 2024/5/1
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (alreadySorted(head, null)) {
            return head;
        }
        return sortSubList(head, null);
    }

    private ListNode sortSubList(ListNode from, ListNode until) {

        if (from == until) {
            return from;
        }

        if (alreadySorted(from, until)) {
            return from;
        }

        ListNode dh = new ListNode(Integer.MIN_VALUE, from);

        ListNode pre = from;

        while (pre.next != until && pre.next != null) {
            ListNode n = pre.next;
            if (n.val < from.val) {
                pre.next = n.next;
                n.next = dh.next;
                dh.next = n;
            } else {
                pre = pre.next;
            }
        }

        dh.next = sortSubList(dh.next, from);
        from.next = sortSubList(from.next, until);

        return dh.next;
    }

    private boolean alreadySorted(ListNode head, ListNode until) {
        if (head == null || head.next == null) {
            return true;
        }

        while(head.next != until) {
            if (head.val > head.next.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        int[] nums = {-1,5,3,4,0};
        ListNode head = Utils.init(nums);
        Utils.print(head);
        head = sl.sortList(head);
        System.out.println();
        Utils.print(head);
    }

}
