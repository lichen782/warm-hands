package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author lich
 * @date 2024/1/18
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;

        while (p1 != null || p2 != null) {
            ListNode next;
            if (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    next = p1;
                    p1 = p1.next;
                } else {
                    next = p2;
                    p2 = p2.next;
                }
            } else {
                if (p1 == null) {
                    next = p2;
                    p2 = p2.next;
                } else {
                    next = p1;
                    p1 = p1.next;
                }
            }
            cur.next = next;
            cur = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        MergeTwoLists m = new MergeTwoLists();
        int[] n1 = {};
        int[] n2 = {1,3,4};
        ListNode l1 = Utils.init(n1);
        ListNode l2 = Utils.init(n2);

        ListNode l3= m.mergeTwoLists(l1, l2);

        Utils.print(l3);
    }

}
