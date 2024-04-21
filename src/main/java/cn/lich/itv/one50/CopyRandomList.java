package cn.lich.itv.one50;

import cn.lich.itv.utils.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * @author lich
 * @date 2024/1/18
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(0);
        Node op = head;
        Node cur = dummyHead;
        Map<Node, Node> map = new HashMap<>();
        while (op != null) {
            cur.next = new Node(op.val);
            map.put(op, cur.next);
            cur = cur.next;
            op = op.next;
        }

        cur = dummyHead.next;
        op = head;
        while (op != null) {
            if (op.random != null) {
                cur.random = map.get(op.random);
            }
            op = op.next;
            cur = cur.next;
        }

        return dummyHead.next;
    }

    public static Node initRandNode(Integer[][] nums) {
        Node dummyHead = new Node(0);
        Node cur = dummyHead;
        Node[] ns = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cur.next = new Node(nums[i][0]);
            ns[i] = cur.next;
            cur = cur.next;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i][1] != null) {
                ns[i].random = ns[nums[i][1]];
            }
        }
        return dummyHead.next;
    }

    public static void print(Node n) {
        while (n != null) {
            System.out.print(n.val);
            if (n.next != null) {
                System.out.print("->");
            }
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CopyRandomList cp = new CopyRandomList();
        Integer[][] nums = {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};

        Node no = initRandNode(nums);
        Node nh = cp.copyRandomList(no);

        print(nh);

    }
}
