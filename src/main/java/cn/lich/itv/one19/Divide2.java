package cn.lich.itv.one19;

/**
 * * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *  *
 *  *
 *  *
 *  * 注意：
 *  *
 *  * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *  * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *  *
 *  *
 *  * 示例 1：
 *  *
 *  * 输入：a = 15, b = 2
 *  * 输出：7
 *  * 解释：15/2 = truncate(7.5) = 7
 *  * 示例 2：
 *  *
 *  * 输入：a = 7, b = -3
 *  * 输出：-2
 *  * 解释：7/-3 = truncate(-2.33333..) = -2
 *  * 示例 3：
 *  *
 *  * 输入：a = 0, b = 1
 *  * 输出：0
 *  * 示例 4：
 *  *
 *  * 输入：a = 1, b = 1
 *  * 输出：1
 *
 * @author lich
 * @date 2024/3/10
 */
public class Divide2 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) { // 溢出
                return Integer.MAX_VALUE;
            }
        }

        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }

        if (a == 0) {
            return 0;
        }

        boolean rev = false;

        // 除数和被除数变成负数
        // 因为负数变成正数，有溢出风险，例如 Integer.MIN_VALUE 变成正数溢出
        if (a > 0) {
            a = -a;
            rev = !rev;
        }

        if (b > 0) {
            b = -b;
            rev = !rev;
        }


        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) >> 1;

            boolean check = quickAddCheck(b, mid, a);
            if (check) {
                ans = mid;
                // mid 还不够大啊
                if (mid == Integer.MAX_VALUE) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return rev ? -ans : ans;
    }

    // 在y 和 x为负数的情况下，判断 y * z >= x 是否为真
    private boolean quickAddCheck(int y, int z, int x) {
       int result = 0, add = y;

       while (z != 0) {
           if ((z & 1) == 1) {
               if (result < x - add) {
                   return false;
               }
               result += add;
           }

           if (z != 1) {
               if (add < x - add) {
                   return false;
               }
               add += add;
           }

           z >>= 1;
       }

       return true;
    }
}
