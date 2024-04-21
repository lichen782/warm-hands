package cn.lich.itv.one50;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * @author lich
 * @date 2024/1/7
 */
public class ZConvert {

    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows <= 1) {
            return s;
        }
        int col = s.length() / 2 + (s.length() % 2);
        char[][] m = new char[numRows][col];
        int x, y;
        int zunit = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int zn = (i / zunit) * (numRows - 1);
            int remain = i % zunit;
            if (remain < numRows) {
                x = remain;
                y = zn;
            } else {
                int offset = remain - (numRows - 1);
                x = numRows - 1 - offset;
                y = zn + offset;
            }
            m[x][y] = s.charAt(i);
        }

        // iterate m
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != 0) {
                    //System.out.print(m[i][j]);
                    sb.append(m[i][j]);
                } else {
                    //System.out.print('0');
                }
                //System.out.print(' ');
            }
            //System.out.println();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZConvert z = new ZConvert();
        String s = "AB";

        System.out.println(z.convert(s, 1));
    }
}
