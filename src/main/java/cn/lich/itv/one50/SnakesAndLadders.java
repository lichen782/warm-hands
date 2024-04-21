package cn.lich.itv.one50;

import java.util.*;

/**
 * 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
 * <p>
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * <p>
 * 每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
 * <p>
 * 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n2)] 。
 * 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
 * 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
 * 当玩家到达编号 n2 的方格时，游戏结束。
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格上没有蛇或梯子。
 * <p>
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
 * <p>
 * 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
 * 返回达到编号为 n2 的方格所需的最少移动次数，如果不可能，则返回 -1。
 *
 * @author lich
 * @date 2024/1/28
 */
public class SnakesAndLadders {

    private int nn;

    private int[] road;

    public int snakesAndLadders(int[][] board) {
        this.road = buildRoad(board);
        this.nn = board.length * board.length;

        return bfs();

    }

    private int[] buildRoad(int[][] board) {
        int n = board.length;
        int seq = 1;
        boolean right = true;
        int[] road = new int[n * n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                road[seq] = board[i][right ? j : n - 1 - j];
                seq++;
            }
            right = !right;
        }
        return road;
    }

    private int bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        int step = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(1, step);

        while (!q.isEmpty()) {
            int seq = q.poll();
            int curStep = visited.get(seq);
            List<Integer> nextpos = validNext(seq);
            for (int next : nextpos) {
                if (next == nn) {
                    return curStep + 1;
                }
                if (visited.containsKey(next)) {
                    continue;
                }
                q.add(next);
                visited.put(next, curStep + 1);
            }
        }
        return -1;
    }

    private List<Integer> validNext(int cur) {
        int startSeq = Math.min(cur + 1, nn);
        int endSeq = Math.min(cur + 6, nn);
        List<Integer> validPos = new ArrayList<>();
        for (int k = startSeq; k <= endSeq; k++) {
            if (road[k] != -1) {
                validPos.add(road[k]);
            } else {
                validPos.add(k);
            }
        }
        return validPos;
    }


    public static void main(String[] args) {
        SnakesAndLadders s = new SnakesAndLadders();
        int[][] board =
                {
                        {-1, -1, 27, 13, -1, 25, -1},
                        {-1, -1, -1, -1, -1, -1, -1},
                        {44, -1, 8, -1, -1, 2, -1},
                        {-1, 30, -1, -1, -1, -1, -1},
                        {3, -1, 20, -1, 46, 6, -1},
                        {-1, -1, -1, -1, -1, -1, 29},
                        {-1, 29, 21, 33, -1, -1, -1}
                };
        System.out.println(s.snakesAndLadders(board));
    }
}
