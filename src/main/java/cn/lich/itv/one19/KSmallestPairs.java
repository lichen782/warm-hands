package cn.lich.itv.one19;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.*;

/**
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 *
 * 提示:
 *
 * 1 <= nums1.length, nums2.length <= 104
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 *
 * @author lich
 * @date 2024/4/13
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> q = new PriorityQueue<>(
                Comparator.comparingInt(l -> -l.stream().reduce(0, Integer::sum)));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (q.size() < k) {
                    q.add(makePair(nums1[i], nums2[j]));
                } else {
                    if (q.peek().stream().reduce(0, Integer::sum) > nums1[i] + nums2[j]) {
                        q.remove();
                        q.add(makePair(nums1[i], nums2[j]));
                    }
                }
            }
        }
        ans.addAll(q);
        return ans;
    }

    private List<Integer> makePair(int n1, int n2) {
        List<Integer> ar = new ArrayList<>();
        ar.add(n1);
        ar.add(n2);
        return ar;
    }

    public static void main(String[] args) {
        KSmallestPairs kSmallestPairs = new KSmallestPairs();
        int[] nums1 = {1,2,4,5,6};
        int[] nums2 = {3,5,7,9};
        int k = 3;
        List<List<Integer>> ans = kSmallestPairs.kSmallestPairs(nums1, nums2, k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[" + ans.get(i).get(0) + "," + ans.get(i).get(1) + "],");
        }
        System.out.println();
    }
}
