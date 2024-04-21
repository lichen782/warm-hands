package cn.lich.itv.one50;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 * @author lich
 * @date 2024/2/18
 */
public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int nr = 0;
        int n = x;
        while (x != 0) {
           int remain = x % 10;
           nr *= 10;
           nr += remain;
           x /= 10;
        }

        return nr == n;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(345));
    }

}
