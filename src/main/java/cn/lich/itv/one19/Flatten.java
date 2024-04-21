package cn.lich.itv.one19;

import cn.lich.itv.utils.Utils;
import cn.lich.itv.utils.doubly.Node;

/**
 *
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 * @author lich
 * @date 2024/3/25
 */
public class Flatten {

    public Node flatten(Node head) {
        flattenRecursive(head);
        return head;
    }

    private Node flattenRecursive(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child != null) {
                break;
            }
            p = p.next;
        }

        while (p != null) {
            Node nextParent = null;

            Node nextP = p.child;
            Node tail = nextP;
            if (tail.child!=null) {
                nextParent = tail;
            }

            while (tail.next != null) {
                if (tail.child != null) {
                    nextParent = tail;
                }
                tail = tail.next;
            }
            if (tail.child!=null) {
                nextParent = tail;
            }

            Node q = p.next;
            p.child = null;
            p.next = nextP;
            nextP.prev = p;

            tail.next = q;
            if (q != null) {
                q.prev = tail;
            }

            p = nextParent;
        }

        return head;
    }

    public static void main(String[] args) {
        Flatten f = new Flatten();
        Integer[] nums = {
                //1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12
                //1,null,2,null,3,null
                1,2,3,4,5,6,null,null,null,7,8,null,null,11,12
        };
        Node head = Utils.init(nums);
        Utils.print(head);

        f.flatten(head);
        System.out.println("after");

        Utils.print(head);
    }
}
