package cn.lich.itv.one19;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 *
 * 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/
 * @author lich
 * @date 2024/3/24
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (ci != cj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome i = new IsPalindrome();
        String s = "race a car";
        System.out.println(i.isPalindrome(s));
    }

}
