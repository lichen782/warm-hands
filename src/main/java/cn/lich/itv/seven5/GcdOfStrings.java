package cn.lich.itv.seven5;

/**
 * 对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 *
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * @author lich
 * @date 2024/3/9
 */
public class GcdOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        }

        int end = str2.length();

        while (end > 0) {
            if (isSubStringDivideOf(str2, end, str2) && isSubStringDivideOf(str2, end, str1)) {
                return str2.substring(0, end);
            }
            end--;
        }

        return "";
    }

    private boolean isSubStringDivideOf(String src, int end, String dest) {
        if (dest.length() % end != 0) {
            return false;
        }
        String subString = src.substring(0, end);
        for (int i = 0; i < dest.length(); i += end) {
            if (!dest.substring(i, i + end).equals(subString)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GcdOfStrings g = new GcdOfStrings();
        System.out.println(g.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}
