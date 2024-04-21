package cn.lich.itv.one50;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 * @author lich
 * @date 2024/1/6
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int cur = 1;
        int sum = cur;
        int peak = 0;
        int peakCur = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                peak = i;
                cur = (ratings[i] == ratings[i - 1] ? 1: cur + 1);
                peakCur = cur;
                sum += cur;
            } else {
                // 严格小于
                cur = 1;
                if (i - peak < peakCur) {
                    sum += i - peak;
                } else {
                    sum += i - peak + 1;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        int[] rating = { 1,3,2,2,1 };
        System.out.println(c.candy(rating));
    }
}
