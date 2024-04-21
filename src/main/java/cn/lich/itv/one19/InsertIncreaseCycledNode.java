package cn.lich.itv.one19;

import cn.lich.itv.utils.Node;
import cn.lich.itv.utils.Utils;

/**
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 * @author lich
 * @date 2024/3/28
 */
public class InsertIncreaseCycledNode {

    public Node insert(Node head, int insertVal) {
        Node iv = new Node(insertVal);
        if (head == null) {
            iv.next = iv;
            return iv;
        }

        Node p = head;
        Node start = null;

        while (p.next != head) {
            if (p.next.val < p.val) {
                start = p.next;
                break;
            } else {
                p = p.next;
            }
        }
        if (start == null) {
            start = head;
        }

        p = start;

        while (p.next != start) {
            if (p.val <= insertVal && insertVal <= p.next.val) {
                break;
            } else {
                p = p.next;
            }
        }

        //插入到p和p.next之间
         Node q = p.next;
         p.next = iv;
         iv.next = q;

         return head;

    }

    public static void main(String[] args) {
        InsertIncreaseCycledNode in = new InsertIncreaseCycledNode();
        int[] nums = {3,5,1};
        Node head = Utils.initWithCycle(nums, 0);
        Node head2 = in.insert(head, 0);

        Utils.printWithCycleCheck(head2);
    }
}
