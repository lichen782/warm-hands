package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * @author lich
 * @date 2024/1/18
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int i = 1;
        ListNode pp = dummyHead, pq = dummyHead;
        ListNode p = dummyHead.next, q = dummyHead.next;

        while (i < left && p != null) {
            pp = pp.next;
            pq = pq.next;
            p = p.next;
            q = q.next;
            i++;
        }

        while (i <= right && q != null) {
            pq = pq.next;
            q = q.next;
            i++;
        }

        // pp is the final first one's previous
        // pq is the first one
        while (pp.next != pq) {
            pp.next = p.next;
            pq.next = p;
            p.next = q;

            p = pp.next;
            q = pq.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ReverseBetween r = new ReverseBetween();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        ListNode l = Utils.init(nums);
        System.out.println("before: ");
        Utils.print(l);
        l = r.reverseBetween(l, 9, 10);

        System.out.println("\nafter: ");
        Utils.print(l);
    }
}
