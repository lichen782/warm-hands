package cn.lich.itv.one19;

/**
 * 给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * @author lich
 * @date 2024/4/21
 */
public class FindMaximumXOR {

    class Node {

        Node[] next = new Node[2];

    }

    private Node root;

    public int findMaximumXOR(int[] nums) {
        root = new Node();
        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);

            Node n = root;
            int x1 = 0;
            for (int j = 30; j >= 0 ; j--) {
                int idx = revert((nums[i] >> j) & 1);
                if (n.next[idx] != null) {
                    n = n.next[idx];
                    x1 = (x1 << 1 | 1);
                } else {
                    n = n.next[revert(idx)];
                    x1 = x1 << 1;
                }
            }
            x = Math.max(x1, x);
        }

        return x;
    }

    private int revert(int b) {
        return b == 1 ? 0 : 1;
    }

    private void add(int num) {
        Node n = root;
        for (int i = 30; i >=0 ; i--) {
           int idx = (num >> i) & 1;
           if (n.next[idx] == null) {
               n.next[idx] = new Node();
           }
           n = n.next[idx];
        }
    }

    public static void main(String[] args) {
        FindMaximumXOR f = new FindMaximumXOR();
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(f.findMaximumXOR(nums));
    }
}
