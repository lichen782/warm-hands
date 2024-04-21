package cn.lich.itv.one50;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * @author lich
 * @date 2024/1/7
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int st = i;
            int j = 0;
            while(j < needle.length() && st < haystack.length() && haystack.charAt(st) == needle.charAt(j)) {
                st++;
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr s = new StrStr();
        System.out.println(s.strStr("mississippi", "issipi"));
    }
}
