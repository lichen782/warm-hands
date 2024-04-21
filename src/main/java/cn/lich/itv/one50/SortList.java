package cn.lich.itv.one50;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @author lich
 * @date 2024/2/6
 */
public class SortList {

    public ListNode sortList2(ListNode head) {
        return sortInternal(head);
    }

    private ListNode sortInternal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        System.out.println("mid: " + mid);

        ListNode midNext = mid.next;

        mid.next = null;

        ListNode h1 = sortInternal(head);
        ListNode h2 = sortInternal(midNext);

        return mergeTwoSorted(h1, h2);
    }

    private ListNode mergeTwoSorted(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummyHead;

        while (h1 != null && h2 != null) {
            ListNode nextToGet = h1.val < h2.val ? h1 : h2;
            cur.next = nextToGet;
            cur = nextToGet;
            if (h1.val < h2.val ){
                h1 = h1.next;
            } else {
                h2 = h2.next;
            }
        }

        cur.next = h1 == null ? h2 : h1;

        return dummyHead.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode q = dummy;

        while (q.next != null) {
            ListNode preOfMin = minPre(q);
            ListNode p = preOfMin.next;
            preOfMin.next = p.next;
            p.next = q.next;
            q.next = p;

            q = q.next;
        }

        return dummy.next;
    }

    private ListNode minPre(ListNode head) {
        ListNode cur = head;
        ListNode minPre = cur;

        while (cur.next != null) {
            if (cur.next.val < minPre.next.val) {
                minPre = cur;
            }
            cur = cur.next;
        }

        return minPre;
    }

    public static void main(String[] args) {
        SortList s = new SortList();
        int[] nums = {4,2,9,0,7};
        ListNode head = Utils.init(nums);
        Utils.print(head);
        System.out.println("\nafter");
        head = s.sortList2(head);
        Utils.print(head);
    }
}
