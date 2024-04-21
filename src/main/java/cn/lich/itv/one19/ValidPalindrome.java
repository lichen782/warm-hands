package cn.lich.itv.one19;

/**
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 * 示例 3:
 *
 * 输入: s = "abc"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * @author lich
 * @date 2024/3/24
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int iidx = -1, jidx = -1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (ci != cj) {
               iidx = i;
               jidx = j;
               break;
            } else {
                i++;
                j--;
            }
        }
        if (iidx == -1) {
            return true;
        }

        return isPalindrome(s, iidx + 1, jidx) || isPalindrome(s, iidx, jidx - 1);
    }

    private boolean isPalindrome(String s, int i, int j) {
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
        ValidPalindrome v = new ValidPalindrome();
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(v.validPalindrome(s));
    }
}
