package cn.lich.itv.one19;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 *
 *
 * 注意：
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
 *
 *
 * 示例 1：
 *
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 *
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 *
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 *
 * 输入：a = 1, b = 1
 * 输出：1
 * @author lich
 * @date 2024/3/9
 */
public class Divide {

    public int divide(int a, int b) {
        boolean positive =  a >= 0 && b >= 0 || a < 0 && b < 0;
        long al = a;
        long bl = b;
        al = Math.abs(al);
        bl = Math.abs(bl);

        if (bl == 1) {
            long ans = positive ? al : -al;
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)ans;
        }

        int i = 0;
        while (al >= bl) {
            al -= bl;
            i++;
            if (i == Integer.MAX_VALUE) {
                return i;
            }
        }

        return positive ? i : -i;

    }

    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            System.out.println("result: " + result + ", " + "add: " + add + ", z: " + z);
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }


    public static void main(String[] args) {
        Divide d = new Divide();
        //System.out.println(d.divide(-2147483648 , -1));

        int x = -23;
        int y = -3;
        int z = 5;
        System.out.println(d.quickAdd(y, z, x));
    }

}
