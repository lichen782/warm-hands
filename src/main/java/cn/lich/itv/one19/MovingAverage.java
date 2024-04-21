package cn.lich.itv.one19;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个窗口大小和一个整数数据流，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *
 *
 * 示例：
 *
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * @author lich
 * @date 2024/4/4
 */
public class MovingAverage {

    private int sum;

    private final int windowSize;

    private Deque<Integer> q;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        sum = 0;
        q = new ArrayDeque<>();
        windowSize = size;
    }

    public double next(int val) {
        if (q.size() == windowSize) {
            int i = q.poll();
            sum -= i;
        }
        q.add(val);
        sum += val;

        return (double)sum / (double) q.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        int[] nums = {1, 10, 3, 5};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(m.next(nums[i]));
        }
    }
}
