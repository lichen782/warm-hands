package cn.lich.itv.one19;

/**
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 *
 * 正数的平方根有两个，只输出其中的正数平方根。
 *
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 *
 *
 * 示例 1:
 *
 * 输入: x = 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 *
 *
 * 提示:
 *
 * 0 <= x <= 231 - 1
 *
 * @author lich
 * @date 2024/4/24
 */
public class MySqrt {

    public int mySqrt(int x) {
        double xn = (double)x / 2d;
        double diff = 0.1;
        while (Math.abs(x - xn * xn) > diff) {
            xn = xn / 2d + x / (2d * xn);
        }

        return (int)(xn);
    }

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        System.out.println(m.mySqrt(8));
    }
}
