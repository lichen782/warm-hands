package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * @author lich
 * @date 2024/1/20
 */
public class ListNodePartition {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-101, head);

        ListNode firstGreater = dummyHead;

        while (firstGreater.next != null && firstGreater.next.val < x) {
            firstGreater = firstGreater.next;
        }

        ListNode p = firstGreater.next;
        while (p != null && p.next != null) {
            if (p.next.val < x) {
                ListNode q = firstGreater.next;
                ListNode s = p.next;
                firstGreater.next = p.next;
                p.next = s.next;
                s.next = q;
                firstGreater = firstGreater.next;
            } else {
                p = p.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNodePartition l = new ListNodePartition();
        int[] nums = {1,4,3,2,5,2};
        ListNode head = Utils.init(nums);
        head = l.partition(head, 3);
        Utils.print(head);
    }
}
