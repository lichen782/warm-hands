package cn.lich.itv.one05;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * s[i]仅包含小写字母
 * 如果你不使用额外的数据结构，会很加分。
 * @author lich
 * @date 2024/3/9
 */
public class IsUnique {

    public boolean isUnique(String astr) {
        int bitmap = 0;
        for (int i = 0; i < astr.length(); i++) {
            int offset = astr.charAt(i) - 'a';
            if (((1 << offset) & bitmap) != 0) {
                return false;
            }
            bitmap |= 1 << offset;
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique i = new IsUnique();
        System.out.println(i.isUnique("ltcode"));
    }
}
