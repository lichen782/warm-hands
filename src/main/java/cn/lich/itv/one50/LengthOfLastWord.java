package cn.lich.itv.one50;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 *
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 *
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 * @author lich
 * @date 2024/1/7
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] ws = s.split("\\s");
        if (ws.length > 0) {
            return ws[ws.length - 1].length();
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] words = {"Hello World", "   fly me   to   the moon  ", "luffy is still joyboy"};
        LengthOfLastWord l = new LengthOfLastWord();

        for (String s : words) {
            System.out.println(s + ": " + l.lengthOfLastWord(s));
        }
    }
}
