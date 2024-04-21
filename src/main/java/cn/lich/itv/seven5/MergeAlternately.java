package cn.lich.itv.seven5;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 *
 * @author lich
 * @date 2024/3/6
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if (i <= j) {
                sb.append(word1.charAt(i));
                i++;
            } else {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        if (i == word1.length()) {
            sb.append(word2.substring(j));
        } else {
            sb.append(word1.substring(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeAlternately m = new MergeAlternately();
        String[][] testcases = {
                {"abc", "pqr"},
                {"ab", "pqrs"},
                {"abcd", "pq"},
        };
        for (String[] cs: testcases) {
            System.out.println(m.mergeAlternately(cs[0], cs[1]));
        }
    }
}
