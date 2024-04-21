package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author lich
 * @date 2024/1/20
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);

        ListNode pre = dummyHead;
        ListNode last = null;

        while (pre != null && (last = moveByK(pre, k)) != null) {
            ListNode nextPre = pre.next;
            reverseBetween(pre, last);
            pre = nextPre;
        }

        return dummyHead.next;
    }

    private ListNode moveByK(ListNode pre, int k) {
        ListNode p = pre;
        while (k > 0 && p != null) {
            k--;
            p = p.next;
        }

        return p;
    }

    /**
     * 不断地将pre.next放到last.next的过程。
     * 注意，如果反过来，把last.next放到pre.next的话，虽然也可以逆转
     * 但是由于链表是从左到右，所以会造成断链。
     *
     * 所有要把前面的往后放，直到移动last到pre.next
     * @param pre
     * @param last
     * @return
     */
    private ListNode reverseBetween(ListNode pre, ListNode last) {

        if (last == null) {
            return pre.next;
        }

        while (pre.next != last) {
            ListNode p = pre.next;
            ListNode q = last.next;

            last.next = p;
            pre.next = p.next;
            p.next = q;
        }

        return pre.next;
    }

    public static void main(String[] args) {
        ReverseKGroup rg = new ReverseKGroup();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        ListNode head = Utils.init(nums);
        head = rg.reverseKGroup(head, k);

        Utils.print(head);
    }
}
