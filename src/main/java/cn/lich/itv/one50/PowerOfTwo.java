package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2023/8/27
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) {
            n = n >> 1;
        }
        return n >> 1 == 0;

    }

    public static void main(String[] args) {
        PowerOfTwo p = new PowerOfTwo();
        System.out.println(p.isPowerOfTwo(-16));
    }
}
