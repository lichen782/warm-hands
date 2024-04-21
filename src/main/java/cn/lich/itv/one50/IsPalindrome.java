package cn.lich.itv.one50;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * @author lich
 * @date 2024/1/7
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isAlphaOrNumber(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphaOrNumber(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j) &&
                    !(isAlpha(s.charAt(i)) && isAlpha(s.charAt(j)) && Math.abs(s.charAt(i) - s.charAt(j)) == 32)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaOrNumber(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    private boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {
        IsPalindrome p = new IsPalindrome();
        System.out.println(p.isPalindrome("0P"));
    }
}
