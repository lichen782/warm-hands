package cn.lich.itv.one50;

import java.util.*;

/**
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * @author lich
 * @date 2024/2/15
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pos = pq.poll();
            ans.add(makePair(nums1[pos[0]], nums2[pos[1]]));
            if (pos[1] + 1 < nums2.length) {
                pq.add(new int[]{pos[0], pos[1] + 1});
            }
            k--;
        }

        return ans;
    }

    private List<Integer> makePair(int n1, int n2) {
        return Arrays.asList(n1, n2);
    }

    public static void main(String[] args) {
        KSmallestPairs ks = new KSmallestPairs();
        int[] nums1 = {1,2,4,5,6};
        int[] nums2 = {3,5,7,9};
        int k = 3;
        List<List<Integer>> l = ks.kSmallestPairs(nums1, nums2, k);
        System.out.print("[");
        for (List<Integer> ll: l) {
            System.out.print("[");
            System.out.print(ll.get(0) + ",");
            System.out.print(ll.get(1));
            System.out.print("]");
        }
        System.out.print("]");
    }
}
