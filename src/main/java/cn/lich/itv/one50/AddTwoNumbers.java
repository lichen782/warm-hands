package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author lich
 * @date 2024/1/18
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode rHead = null;
        ListNode rCur = null;

        int acc = 0;

        while (p1 != null || p2 != null) {

            int result = (p1 != null ? p1.val : 0) +  (p2 != null ? p2.val : 0) + acc;

            acc = result / 10;

            ListNode r = new ListNode(result % 10);
            if (rHead == null) {
                rHead = rCur = r;
            } else {
                rCur.next = r;
                rCur = r;
            }

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (acc != 0) {
            rCur.next = new ListNode(acc);
        }

        return rHead;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = Utils.init(new int[] {2,4,9,8,2,1});
        ListNode l2 = Utils.init(new int[] {5,6,4});

        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        Utils.print(result);
    }

}
