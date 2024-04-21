package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * @author lich
 * @date 2024/3/24
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> al1 = toArray(l1);
        List<Integer> al2 = toArray(l2);

        List<Integer> result = new ArrayList<>();

        int i1 = al1.size() - 1;
        int i2 = al2.size() - 1;
        int step = 0;

        while (i1 >= 0 || i2 >= 0) {
            int sum = (i1 >= 0 ? al1.get(i1) : 0) + (i2 >= 0 ? al2.get(i2) : 0 ) + step;
            result.add(sum % 10);
            step = sum / 10;
            if (i1 >= 0) {
                i1--;
            }
            if (i2 >= 0) {
                i2--;
            }
        }

        if (step != 0) {
            result.add(step);
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (int i = result.size() - 1; i >= 0 ; i--) {
            ListNode n = new ListNode(result.get(i));
            p.next = n;
            p = p.next;
        }

        return dummy.next;
    }

    private List toArray(ListNode l) {
        List<Integer> ans = new ArrayList<>();

        while (l != null) {
            ans.add(l.val);
            l = l.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        AddTwoNumbers a = new AddTwoNumbers();
        int[] nums1 = {5,5,9};
        int[] nums2 = {5,6,4};
        ListNode head = a.addTwoNumbers(Utils.init(nums1), Utils.init(nums2));
        Utils.print(head);
    }

}
