package cn.lich.itv.one50;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * @author lich
 * @date 2024/2/17
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int c = 0;
        int i = 0;
        while(i < 32) {
            if ((n & 1) != 0) {
                c++;
            }
            n >>= 1;
            i++;
        }
        return c;
    }

    public static void main(String[] args) {
        HammingWeight hw = new HammingWeight();
        System.out.println(hw.hammingWeight(-3));
    }
}
