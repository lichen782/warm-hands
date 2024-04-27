package cn.lich.itv.one19;

import java.util.*;

/**
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 * @author lich
 * @date 2024/4/23
 */
public class RandomPickIndex {

    private int[] sum;

    public RandomPickIndex (int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        Random r = new Random();
        int target = r.nextInt(sum[sum.length - 1]);
        int insertPlace = binarySearch(sum, target);
        return insertPlace;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid + 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] w = {1, 3};
        RandomPickIndex p = new RandomPickIndex(w);

        Map<Integer, Integer> counter = new TreeMap<>();
        int total = 100;
        for (int i = 0; i < total; i++) {
            int idx = p.pickIndex();
            int c = counter.getOrDefault(idx, 0);
            counter.put(idx, c + 1);
        }

        for (Integer idx: counter.keySet()) {
            System.out.println((float) counter.get(idx) / (float) 100);
        }
    }
}
