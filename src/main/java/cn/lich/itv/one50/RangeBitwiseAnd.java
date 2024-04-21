package cn.lich.itv.one50;

/**
 *
 * @author lich
 * @date 2024/2/17
 */
public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }

        int offset = 0;
        while (left + 1 < right) {
            left >>= 1;
            right >>= 1;
            offset += 1;
        }
        return (left & right) << offset;
    }


    public static void main(String[] args) {
        RangeBitwiseAnd r = new RangeBitwiseAnd();
        System.out.println(r.rangeBitwiseAnd(600000000, 2147483645));
        //System.out.println(r.rangeBitwiseAnd(1, 2147483647));
    }
}
