package cn.lich.itv.one50;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 *
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 *
 * MedianFinder() 初始化 MedianFinder 对象。
 *
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 *
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 *
 * 示例 1：
 *
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 *
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * @author lich
 * @date 2024/2/17
 */
public class MedianFinder {

    private PriorityQueue<Integer> pqUpper;

    private PriorityQueue<Integer> pqLower;

    public MedianFinder() {
        pqUpper = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        pqLower = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
    }

    public void addNum(int num) {
        if (!pqUpper.isEmpty() && num >= pqUpper.peek()) {
            pqUpper.add(num);
        } else {
            pqLower.add(num);
        }
        rebalance();
    }

    private void rebalance() {
        PriorityQueue<Integer> lessOne = pqUpper.size() < pqLower.size() ? pqUpper : pqLower;
        PriorityQueue<Integer> moreOne = lessOne == pqUpper ? pqLower : pqUpper;

        while (moreOne.size() > lessOne.size()) {
            lessOne.add(moreOne.remove());
        }
    }

    public double findMedian() {
        if (pqUpper.size() == pqLower.size()) {
            return (double)(pqUpper.peek() + pqLower.peek())/2.0d;
        } else {
            return pqLower.size() > pqUpper.size() ? pqLower.peek() : pqUpper.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.5
    }
}
