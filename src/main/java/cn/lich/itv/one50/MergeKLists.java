package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/2/7
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        for (int i = 0; i < lists.length - 1; i++) {
            ListNode head = merge(lists[i], lists[i + 1]);
            lists[i + 1] = head;
        }

        return lists[lists.length - 1];
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;

        while (h1 != null && h2 != null) {
            ListNode p = h1.val < h2.val ? h1 : h2;
            cur.next = p;
            cur = p;
            if (h1.val < h2.val) {
                h1 = h1.next;
            } else {
                h2 = h2.next;
            }
        }

        cur.next = h1 != null ? h1 : h2;

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKLists m = new MergeKLists();
        int[][] nums = {


        };
        ListNode[] l = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            l[i] = Utils.init(nums[i]);
        }
        ListNode head = m.mergeKLists(l);
        Utils.print(head);
    }
}
