package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/2/19
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1 || x == 1) {
            return x;
        }

        if (n < 0 && n != Integer.MIN_VALUE) {
            return 1d / myPow(x, -n);
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * myPow(x, n - 2 * (n / 2));
        }

    }

    public static void main(String[] args) {
        MyPow m = new MyPow();
        System.out.println(m.myPow(2.0, 10));
        System.out.println(m.myPow(2.10000, 3));
        System.out.println(m.myPow(2.00000, -2));
        System.out.println(m.myPow(2, -2147483648));
    }

}
