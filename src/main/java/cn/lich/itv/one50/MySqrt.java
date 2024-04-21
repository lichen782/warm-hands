package cn.lich.itv.one50;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @author lich
 * @date 2024/2/19
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double xd = 0.01;
        double xn = x;
        while (true) {
            double xn1 = xn / 2d + (double)x / (2d * xn);
            if (Math.abs(xn1 - xn) <= xd) {
                return (int)xn1;
            }
            xn = xn1;
        }
    }

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        int n = 0;
        System.out.println("math: " + Math.sqrt(n) + "; ans: " + m.mySqrt(n));
    }
}
