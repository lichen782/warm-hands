package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

/**
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * @author lich
 * @date 2024/3/24
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = sizeOf(headA);
        int sizeB = sizeOf(headB);

        if (sizeA > sizeB) {
            return getIntersectionNode(headB, headA);
        }

        // skip long ones
        int diff = sizeB - sizeA;
        while (diff > 0) {
            headB = headB.next;
            diff--;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int sizeOf(ListNode head) {
        ListNode p = head;
        int size = 0;
        while (p != null) {
            p = p.next;
            size++;
        }
        return size;
    }

    private boolean isEqual(ListNode a, ListNode b) {
        return a.val == b.val;
    }



    public static void main(String[] args) {
        GetIntersectionNode g = new GetIntersectionNode();
        int[] numsA = {4,1,8,4,5};
        int[] numsB = {5,0,1,8,4,5};
        ListNode headA = Utils.init(numsA);
        ListNode headB = Utils.init(numsB);
        ListNode intersect = g.getIntersectionNode(headA, headB);
        System.out.println(intersect);
    }
}
