package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * @author lich
 * @date 2024/1/20
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-101, head);

        ListNode p = dummyHead;

        ListNode q = head.next;

        while (q != null) {
            if (p.next.val == q.val) {
                q = q.next;
                if (q == null) {
                    p.next = null;
                }
            } else if (p.next.next != q){
                //(p, q)删除
                p.next = q;
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }


        return dummyHead.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates d = new DeleteDuplicates();
        int[] nums = {1,1};
        ListNode h = Utils.init(nums);
        h = d.deleteDuplicates(h);

        Utils.print(h);
    }
}
