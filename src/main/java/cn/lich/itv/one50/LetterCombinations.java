package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * @author lich
 * @date 2024/2/2
 */
public class LetterCombinations {

    private List<String> result = new ArrayList<>();

    private String digits;

    private char[][] board = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        result.clear();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");
        this.digits = digits;
        accumulate(this.digits.length() - 1);
        return result;
    }

    private void accumulate(int until) {
        if (until < 0 || until >= digits.length()) {
            return;
        }

        accumulate(until - 1);

        char n = digits.charAt(until);
        char[] aph = board[n - '2'];

        List<String> rsl = new ArrayList<>();
        for (String s : result) {
            for (char a: aph){
                rsl.add(s + a);
            }
        }
        result.clear();
        result.addAll(rsl);
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        String digits = "2";
        List<String> combines = l.letterCombinations(digits);
        for (String com: combines) {
            System.out.print(com + ",");
        }
    }

}
