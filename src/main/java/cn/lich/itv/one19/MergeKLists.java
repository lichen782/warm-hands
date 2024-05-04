package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个链表数组，每个链表都已经按升序排列。
 *
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * @author lich
 * @date 2024/5/2
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dh = new ListNode(Integer.MIN_VALUE);

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode n: lists) {
            if (n != null) {
                pq.add(n);
            }
        }

        ListNode pre = dh;

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            pre.next = n;
            pre = n;
            if (n.next != null) {
                pq.add(n.next);
                n.next = null;
            }
        }

        return dh.next;
    }

    public static void main(String[] args) {
        MergeKLists m = new MergeKLists();
        int[][] nums = {
                {1,4,5},
                {1,3,4},
                {2,6},
        };
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = Utils.init(nums[i]);
        }
        ListNode head = m.mergeKLists(lists);
        Utils.print(head);
    }
}
