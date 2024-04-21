package cn.lich.itv.one19;

import java.util.Arrays;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * @author lich
 * @date 2024/3/30
 */
public class AlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        int[] table = orderTable(order);
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], table) <= 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private int[] orderTable(String order) {
        assert order.length() == 26;
        int[] table = new int[26];
        for (int i = 0; i < order.length(); i++) {
            int offset = order.charAt(i) - 'a';
            table[offset] = i;
        }
        return table;
    }

    private int compare(String word1, String word2, int[] table) {
        int i = 0, j = 0;
        if (word1.equals(word2)) {
            return 0;
        }
        while (i < word1.length() && j < word2.length()) {
            int offset1 = word1.charAt(i) - 'a';
            int offset2 = word2.charAt(j) - 'a';
            if (table[offset1] > table[offset2]) {
                return 1;
            } else if (table[offset1] < table[offset2]) {
                return -1;
            }
            i++;
            j++;
        }
        if (word1.length() < word2.length()) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        String[] words = {"kuvp","q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        AlienSorted a = new AlienSorted();
        System.out.println(a.isAlienSorted(words, order));
    }
}
