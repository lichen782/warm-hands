package cn.lich.itv.one50;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lich
 * @date 2024/1/15
 */
public class Happy {

    public boolean isHappy(int n) {
        Set<Integer> appears = new HashSet<>();
        while(n != 1) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            if (appears.contains(n)) {
               break;
            }
            appears.add(n);
        }

        return n == 1;
    }

    public static void main(String[] args) {
        Happy h = new Happy();
        int[] nums = {19, 1, 2};
        for (int n: nums) {
            System.out.println(n + " is " + h.isHappy(n));
        }
    }
}
