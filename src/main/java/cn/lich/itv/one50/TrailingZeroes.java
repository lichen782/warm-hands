package cn.lich.itv.one50;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 * @author lich
 * @date 2024/2/18
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int twos = 0;
        int fives = 0;
        for (int i = 1; i <= n; i++) {
            twos += count2sOfInt(i);
            fives += count5sOfInt(i);
        }
        return Math.min(twos, fives);
    }

    private int count2sOfInt(int n) {
        int c = 0;
        while (n != 0 && n % 2 == 0) {
            c++;
            n >>= 1;
        }
        return c;
    }

    private int count5sOfInt(int n) {
        int c = 0;
        while (n != 0 && n % 5 == 0) {
            c++;
            n /= 5;
        }
        return c;
    }

    public static void main(String[] args) {
        TrailingZeroes t = new TrailingZeroes();
        int n = 3;
        System.out.println(t.trailingZeroes(0));
    }
}
