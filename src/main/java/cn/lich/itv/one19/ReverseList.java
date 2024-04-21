package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 * @author lich
 * @date 2024/3/24
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
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
        ReverseList r = new ReverseList();
        int[] nums = {1,2,3,4,5};
        ListNode head = Utils.init(nums);

        Utils.print(r.reverseList(head));

    }

}
