package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 *
 *
 *
 * 输入: head = [1,2]
 * 输出: false
 *
 *
 * 提示：
 *
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 *
 *
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author lich
 * @date 2024/3/24
 */
public class IsPalindromeListNode {

    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        ListNode q = head;

        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }

        // p should be mid
        p = reverse(p);

        while (p != null && head != null) {
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
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
        IsPalindromeListNode i = new IsPalindromeListNode();
        int[] nums = {1,2};
        ListNode head = Utils.init(nums);
        System.out.println(i.isPalindrome(head));
    }
}
