/*
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
*/
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxSize = 0;
        int size;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    size = dfs(x, y, grid);
                    if (size > maxSize) maxSize = size;
                }
            }
        }
        return maxSize;
    }

    public int dfs(int x, int y, int[][] grid) {
        if (x > grid.length - 1 || x < 0 || y > grid[0].length - 1 || y < 0 || grid[x][y] != 1 ) return 0;
        grid[x][y]++;
        return dfs(x + 1, y, grid) + dfs(x - 1, y, grid) + dfs(x, y + 1, grid) + dfs(x, y - 1, grid) + 1;
    }
}
