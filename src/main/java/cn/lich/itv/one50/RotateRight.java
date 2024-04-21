package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * @author lich
 * @date 2024/1/20
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-101, head);

        ListNode p = dummyHead, q = dummyHead;

        while (k > 0) {
            k--;
            q = q.next != null ? q.next : head;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        // now p should at the pos where p.next should be at first one

        if (p.next != head) {
            dummyHead.next = p.next;
            q.next = head;
            p.next = null;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        RotateRight r = new RotateRight();
        int[] nums = {1,2};

        ListNode h = Utils.init(nums);
        h = r.rotateRight(h, 2);

        Utils.print(h);
    }
}
