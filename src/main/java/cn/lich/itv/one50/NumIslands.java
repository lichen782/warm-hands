package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/27
 */
public class NumIslands {

    private static final char WATER = '0';

    private static final char ISLAND = '1';

    private static final char VISITED = 'x';

    private int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    private int island = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ISLAND) {
                    island++;
                    dfs(grid, i, j);
                }
            }
        }

        return island;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != ISLAND) {
            return;
        }

        grid[i][j] = VISITED;

        for (int k = 0; k < directions.length; k++) {
            int ii = i + directions[k][0];
            int jj = j + directions[k][1];
            if (valid(grid, ii, jj)) {
                dfs(grid, ii ,jj);
            }
        }

    }

    private boolean valid(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public static void main(String[] args) {
        NumIslands n = new NumIslands();
        char[][] grid = {
                {'1', '1', '1', '0', '0'},
                {'0', '1', '0', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int k = n.numIslands(grid);
        System.out.println(k);
    }
}
