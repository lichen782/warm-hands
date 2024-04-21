package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 注意:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * @author lich
 * @date 2024/3/1
 */
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> ans = new ArrayList<>();
        while (i < words.length) {
            int forward = 0;
            int remain = maxWidth;
            while (remain > 0 && i + forward < words.length) {
                int nextLengthConsumed = (forward == 0 ? 0 : 1) + words[i + forward].length();
                if (remain - nextLengthConsumed >= 0) {
                    remain -= nextLengthConsumed;
                    forward++;
                } else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (forward == 1) {
                sb.append(words[i]);
                appendSpaces(sb, maxWidth - words[i].length());
                ans.add(sb.toString());
                i += forward;
                continue;
            }
            boolean lastLine = (i + forward == words.length);
            //[i, i + forward), and try to fill remain spaces
            int perSpaces = lastLine ? 0 : remain / (forward - 1);
            int leftSpaces = lastLine ? 0 : remain % (forward - 1);
            for (int j = 0; j < forward; j++) {
                sb.append(words[i + j]);
                if (lastLine || remain > 0) {
                    int spaceToAppend = perSpaces + (leftSpaces > 0 ? 1 : 0);
                    leftSpaces--;
                    appendSpaces(sb, spaceToAppend);
                    remain -= spaceToAppend;
                }
                if (j != forward - 1) {
                    appendSpaces(sb, 1);
                }
            }
            appendSpaces(sb, remain);
            ans.add(sb.toString());
            i += forward;
        }

        return ans;

    }

    private StringBuilder appendSpaces(StringBuilder sb, int n) {
        while (n > 0) {
            sb.append(" ");
            n--;
        }
        return sb;
    }

    public static void main(String[] args) {
        FullJustify f = new FullJustify();
        String[] words = {
                "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"
        };
        int maxWidth = 16;
        List<String> ans = f.fullJustify(words, maxWidth);
        for (String line: ans) {
            System.out.println(line);
        }
    }
}
