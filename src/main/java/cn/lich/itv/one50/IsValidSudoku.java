package cn.lich.itv.one50;

/**
 *
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * @author lich
 * @date 2024/1/12
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[] lot = new boolean[n];
        for (int i = 0; i < n; i++) {
            // for each row
            reset(lot);
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int pos = board[i][j] - '1';
                if (lot[pos]) {
                    return false;
                }
                lot[pos] = true;
            }
            // each column
            reset(lot);
            for (int j = 0; j < n; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int pos = board[j][i] - '1';
                if (lot[pos]) {
                    return false;
                }
                lot[pos] = true;
            }
            reset(lot);

            //each small cube
            int st_i = (i / 3) * 3;
            int st_j = (i % 3) * 3;
            for (int p = 0; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    if (board[st_i + p][st_j + q] == '.') {
                        continue;
                    }
                    int pos = board[st_i + p][st_j + q] - '1';
                    if (lot[pos]) {
                        return false;
                    }
                    lot[pos] = true;
                }
            }
        }

        return true;
    }

    private void reset(boolean[] lot) {
        for (int i = 0; i < lot.length; i++) {
            lot[i] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board =
        {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        IsValidSudoku i = new IsValidSudoku();
        System.out.println(i.isValidSudoku(board));
    }
}
