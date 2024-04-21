package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author lich
 * @date 2024/1/20
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode p = dummyHead;
        ListNode q = dummyHead;

        while (q != null && n > 0) {
            n--;
            q = q.next;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        ListNode deletedOne = p.next;
        p.next = deletedOne != null ? deletedOne.next : null;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        int[] nums = {1,2};

        ListNode h = Utils.init(nums);
        h = r.removeNthFromEnd(h, 1);

        Utils.print(h);

    }


}
