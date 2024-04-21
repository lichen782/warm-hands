package cn.lich.itv.one19;

import cn.lich.itv.utils.ListNode;
import cn.lich.itv.utils.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 * @author lich
 * @date 2024/3/24
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        Set<ListNode> s = new HashSet<>();
        s.add(p);

        while (p.next != null) {
            if (s.contains(p.next)) {
                return p.next;
            } else {
                s.add(p.next);
            }
            p = p.next;
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        DetectCycle d = new DetectCycle();
        for (int i = 0; i < nums.length; i++) {
            ListNode head = Utils.initListNodeWithCycle(nums, i);
            System.out.println(d.detectCycle(head));
        }
    }
}
