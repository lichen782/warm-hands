package cn.lich.itv.one19;

/**
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author lich
 * @date 2024/3/12
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int step = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int ai = i >= 0 ? (a.charAt(i) - '0') : 0;
            int bi = j >=0 ? (b.charAt(j) - '0') : 0;
            int sum = ai + bi + step;
            sb.append(sum & 1);
            step = sum >> 1;
            if (i >= 0) {
                i--;
            }
            if (j >= 0) {
                j--;
            }
        }

        if (step == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();

        System.out.println(a.addBinary("100", "10"));
    }
}
