package cn.lich.itv.one19;

import cn.lich.itv.utils.Utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *
 * 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * @author lich
 * @date 2024/4/13
 */
public class TopKFrequent {

    class Count {
        private int n;

        private int c;

        Count(int n) {
            this.n = n;
            c = 0;
        }
    }

    private PriorityQueue<Integer> queue;

    private Map<Integer, Count> map;

    public int[] topKFrequent(int[] nums, int k) {

        map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Count c = map.getOrDefault(nums[i], new Count(nums[i]));
            c.c++;
            map.put(nums[i], c);
        }

        queue = new PriorityQueue<>(Comparator.comparingInt(n -> map.get(n).c));

        for (Integer n: map.keySet()) {
            if (queue.size() < k) {
                queue.offer(n);
            } else {
                int kn = queue.peek();
                Count c = map.get(kn);
                if (c.c < map.get(n).c) {
                    queue.poll();
                    queue.add(n);
                }
            }
        }

        int[] ans = new int[queue.size()];
        Integer[] ansi = queue.toArray(new Integer[queue.size()]);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansi[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        int[] nums = {1};
        int k = 1;
        int [] tops = t.topKFrequent(nums, k);
        Utils.print(tops);
    }
}
