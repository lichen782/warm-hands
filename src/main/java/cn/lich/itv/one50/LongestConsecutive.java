package cn.lich.itv.one50;

import java.util.*;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @author lich
 * @date 2024/1/15
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer e: nums) {
            set.add(e);
        }

        int longestRange = 0;

        for (Integer e: nums) {
            if (!set.contains(e)) {
                continue;
            }
            set.remove(e);
            int leftmost = e - 1;
            while(!set.isEmpty() && set.contains(leftmost)) {
                set.remove(leftmost);
                leftmost--;
            }
            int rightmost = e + 1;
            while(!set.isEmpty() && set.contains(rightmost)) {
                set.remove(rightmost);
                rightmost++;
            }

            longestRange = Math.max(rightmost - leftmost - 1, longestRange);

        }
        return longestRange;
    }

    public static void main(String[] args) {
        LongestConsecutive l = new LongestConsecutive();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(l.longestConsecutive(nums));
    }
}
