package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * @author lich
 * @date 2024/3/24
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p = dummy, q = dummy;

        while (n > 0 && q.next != null ) {
            q = q.next;
            n--;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        ListNode deleted = p.next;

        if (deleted != null) {
            p.next = deleted.next;
            deleted.next = null;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = Utils.init(nums);
        head = r.removeNthFromEnd(head, 2);
        Utils.print(head);
    }
}
