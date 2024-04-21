package cn.lich.itv.utils;

import cn.lich.itv.utils.tree.Node;

import java.util.*;

import static cn.lich.itv.utils.quadtree.Node.empty;

/**
 * @author lich
 * @date 2024/1/18
 */
public class Utils {

    public static ListNode initListNodeWithCycle(int[] num, int pos) {
        ListNode head = null, cur = null, cycle = null;
        for (int i = 0; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            if (pos == i) {
                cycle = node;
            }
            if (i == 0) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        cur.next = cycle;
        return head;
    }

    public static ListNode init(int[] nums) {
        ListNode head = null, cur = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            if (i == 0) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        return head;
    }

    public static cn.lich.itv.utils.Node initWithCycle(int[] nums, int retPos) {
        if (nums.length == 0) {
            return null;
        }
        cn.lich.itv.utils.Node pre = new cn.lich.itv.utils.Node(nums[0]);;
        cn.lich.itv.utils.Node first = pre;
        cn.lich.itv.utils.Node head = null;
        if (retPos == 0) {
            head = pre;
        }
        for (int i = 1; i < nums.length; i++) {
            pre.next = new cn.lich.itv.utils.Node(nums[i]);
            if (retPos == i) {
                head = pre.next;
            }

            pre = pre.next;
        }

        pre.next = first;

        return head;
    }

    public static void printWithCycleCheck(cn.lich.itv.utils.Node head) {
        if (head == null) {
            return;
        }
        cn.lich.itv.utils.Node p = head;

        System.out.print("[");
        while (p.next != null && p.next != head) {
            System.out.print(p.val + ", ");
            p = p.next;
        }

        System.out.print(p.val + "]");
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            if (l.next != null) {
                System.out.print("->");
            }
            l = l.next;
        }
    }

    public static TreeNode initTreeNode(Integer[] initArray) {
        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(initArray[0]);
        q.add(root);
        int i = 1;
        while (i < initArray.length) {
            TreeNode curRoot = q.pop();
            if (initArray[i] != null) {
                curRoot.left = new TreeNode(initArray[i]);
                q.add(curRoot.left);
            }
            i++;
            if (i >= initArray.length) {
                break;
            }
            if (initArray[i] != null) {
                curRoot.right = new TreeNode(initArray[i]);
                q.add(curRoot.right);
            }
            i++;
        }

        return root;
    }

    public static TreeNode findTreeNodeWithVal(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (root.left != null) {
            TreeNode leftResult = findTreeNodeWithVal(root.left, val);
            if (leftResult != null) {
                return leftResult;
            }
        }
        if (root.right != null) {
            TreeNode rightResult = findTreeNodeWithVal(root.right, val);
            if (rightResult != null) {
                return rightResult;
            }
        }

        return null;
    }

    public static Node initNextTreeNode(Integer[] initArray) {
        LinkedList<Node> q = new LinkedList<>();
        Node root = new Node(initArray[0]);
        q.add(root);
        int i = 1;
        while (i < initArray.length) {
            Node curRoot = q.pop();
            if (initArray[i] != null) {
                curRoot.left = new Node(initArray[i]);
                q.add(curRoot.left);
            }
            i++;
            if (i >= initArray.length) {
                break;
            }
            if (initArray[i] != null) {
                curRoot.right = new Node(initArray[i]);
                q.add(curRoot.right);
            }
            i++;
        }

        return root;
    }

    public static cn.lich.itv.utils.graph.Node initAdjGraph(int[][] graph) {
        Map<Integer, cn.lich.itv.utils.graph.Node> nodeMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!nodeMap.containsKey(i + 1)) {
                nodeMap.put(i + 1, new cn.lich.itv.utils.graph.Node(i + 1));
            }

            cn.lich.itv.utils.graph.Node n = nodeMap.get(i + 1);
            for (int j = 0; j < graph[i].length; j++) {
                if (!nodeMap.containsKey(graph[i][j])) {
                    nodeMap.put(graph[i][j], new cn.lich.itv.utils.graph.Node(graph[i][j]));
                }
                n.neighbors.add(nodeMap.get(graph[i][j]));
            }
        }

        return nodeMap.get(1);
    }

    public static void print(cn.lich.itv.utils.graph.Node node) {
        if (node == null) {
            return;
        }
        Map<Integer, cn.lich.itv.utils.graph.Node> nodeMap = new HashMap<>();
        dfs(node, nodeMap);
        nodeMap.keySet().stream().sorted().forEach(
                i -> {
                    System.out.print(i);
                    cn.lich.itv.utils.graph.Node n = nodeMap.get(i);
                    if (n.neighbors.size() > 0) {
                        System.out.print("->");
                    }
                    for (int j = 0; j < n.neighbors.size(); j++) {
                        System.out.print(n.neighbors.get(j).val + ",");
                    }
                    System.out.println();
                }
        );
    }

    private static void dfs(cn.lich.itv.utils.graph.Node node, Map<Integer, cn.lich.itv.utils.graph.Node> nodeMap) {

        if (nodeMap.containsKey(node.val)) {
            return;
        }

        nodeMap.put(node.val, node);

        for (cn.lich.itv.utils.graph.Node neighbor : node.neighbors) {
            dfs(neighbor, nodeMap);
        }
    }

    public static void print(TreeNode node) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.push(node);

        while (!q.isEmpty()) {
            node = q.poll();
            System.out.print((node != null ? node.val : "null") + " ");
            if (node != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
    }

    public static void print(Node node) {
        LinkedList<Node> q = new LinkedList<>();
        q.push(node);

        while (!q.isEmpty()) {
            node = q.poll();
            System.out.print((node != null ? node.val : "null") + " ");
            if (node != null && node.next != null) {
                System.out.print("-> " + node.next.val + " ");
            }
            if (node != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void print(cn.lich.itv.utils.quadtree.Node root) {
        Deque<cn.lich.itv.utils.quadtree.Node> q = new ArrayDeque<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while(!q.isEmpty()) {
            cn.lich.itv.utils.quadtree.Node n = q.remove();
            if (n != empty) {
                sb.append(n + ",");
            } else {
                sb.append("null,");
                continue;
            }
            q.add(n.topLeft != null? n.topLeft : empty);
            q.add(n.topRight != null? n.topRight : empty);
            q.add(n.bottomLeft != null? n.bottomLeft : empty);
            q.add(n.bottomRight != null? n.bottomRight : empty);
        }

        sb.append("]");
        System.out.println(sb);
    }

    public static cn.lich.itv.utils.doubly.Node init(Integer[] nums) {
        cn.lich.itv.utils.doubly.Node curHead = new cn.lich.itv.utils.doubly.Node();
        cn.lich.itv.utils.doubly.Node head = curHead;
        curHead.val = nums[0];
        cn.lich.itv.utils.doubly.Node pre = curHead;
        cn.lich.itv.utils.doubly.Node ppre = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != null) {
                cn.lich.itv.utils.doubly.Node q = new cn.lich.itv.utils.doubly.Node();
                q.val = nums[i];
                if (pre != null) {
                    pre.next = q;
                    q.prev = pre;
                } else {//新的一层
                    curHead = q;
                    ppre.child = q;
                }
                pre = q;
            } else if (pre != null){
                // 证明是层尾
                pre = null;
                ppre = curHead;
            } else {
                // 证明是层首位，但是还没遇到数字
                ppre = ppre.next;
            }
        }
        return head;
    }

    public static void print(cn.lich.itv.utils.doubly.Node head) {
        cn.lich.itv.utils.doubly.Node p = head;
        StringBuilder sb = new StringBuilder();
        while (p != null) {
            System.out.print(p.val + "->");
            cn.lich.itv.utils.doubly.Node nxt = p.next;
            if (nxt == null) {// 新的一层
                System.out.print("NULL");
                System.out.print("\n");
                p = head;
                while (p.child == null) {
                    appendSpace(sb, lenOfInt(p.val));
                    appendSpace(sb, 4);
                    p = p.next;
                    if (p == null) {
                        break;
                    }
                }
                if (p != null && p.child != null) {
                    System.out.print(sb);
                    p = p.child;
                    head = p;
                    continue;
                } else {
                    return;
                }
            }
            if (nxt.prev == p) {
                System.out.print("<-");
            } else {
                System.out.print("x");
            }
            p = nxt;
        }
    }

    private static void appendSpace(StringBuilder sb, int n) {
        while (n > 0) {
            sb.append(" ");
            n--;
        }
    }

    private static int lenOfInt(int v) {
        int s = 0;
        while (v > 0) {
            v /= 10;
            s++;
        }
        return s;
    }
}
