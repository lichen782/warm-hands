package cn.lich.itv.one50;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 * @author lich
 * @date 2024/2/17
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }

        int bl = b.length() - 1;
        int al = a.length() - 1;
        int step = 0;
        char[] as = a.toCharArray();
        int[] sum = new int[] {0, 0};
        while (bl >= 0 || al >= 0) {
            sum = sumOf(a.charAt(al), bl >= 0 ? b.charAt(bl) : '0', step);
            step = sum[0];
            as[al] = (char)('0' + sum[1]);
            al--;
            bl--;
        }
        StringBuilder sb = new StringBuilder(new String(as));
        if (sum[0] == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    private int[] sumOf(char a, char b, int c) {
        int ai = a - '0';
        int bi = b - '0';
        int ci = c;

        int sum = ai + bi + ci;
        switch (sum) {
            case 0:
                return new int[] {0, 0};
            case 1:
                return new int[] {0, 1};
            case 2:
                return new int[] {1, 0};
            case 3:
                return new int[] {1, 1};
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("1010", "1011"));
    }

}
