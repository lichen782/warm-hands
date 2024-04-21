package cn.lich.itv.one50;


import cn.lich.itv.utils.Utils;

/**
 * @author lich
 * @date 2024/2/18
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int step = 1;
        while (i >= 0) {
            int sum = digits[i] + step;
            step = sum / 10;
            digits[i] = sum % 10;
            if (step == 0) {
                return digits;
            }
            i--;
        }

        int[] ndigits = new int[digits.length + 1];
        ndigits[0] = step;
        for (int j = 0; j < digits.length; j++) {
            ndigits[j + 1] = digits[j];
        }
        return ndigits;
    }

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        int[] nums = {9,9};
        int [] ans = p.plusOne(nums);
        Utils.print(ans);
    }
}
