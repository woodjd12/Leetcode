/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/





class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean empty = false;
        int[] point;
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                if (grid[x][y] == 2) {
                    point = new int[2];
                    point[0] = x;
                    point[1] = y;
                    queue.add(point);
                }
            }
        }
        if (queue.isEmpty()) empty = true;
        int count = bfs(queue, grid);
        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length; x++) {
                if (grid[x][y] == 1) return -1;
            }
        }     
        if (empty) return 0;
        return count;
    }
    
    public int bfs(Queue<int[]> queue, int[][] grid) {
        int[] point;
        int length;
        ArrayList<int[]> neighbors;
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            length = queue.size();
            for (int p = 0; p < length; p++) {
                point = queue.poll();
                neighbors = getNeighbors(point, grid);
                for (int[] neighbor : neighbors) {
                    queue.add(neighbor);
                    grid[neighbor[0]][neighbor[1]]++;
                }
            }
        }
        return count;
    }
    
    public ArrayList<int[]> getNeighbors(int[] point, int[][] grid) {
        int x = point[0];
        int y = point[1];
        int[] left;
        ArrayList<int[]> list = new ArrayList<int[]>();
        if (x - 1 >= 0 && grid[x-1][y] == 1) {
            left = new int[2];
            left[0] = x - 1;
            left[1] = y;
            list.add(left);
        }
        if (x + 1 < grid.length && grid[x+1][y] == 1) {
            left = new int[2];
            left[0] = x + 1;
            left[1] = y;
            list.add(left);
        }
        if (y - 1 >= 0 && grid[x][y-1] == 1) {
            left = new int[2];
            left[0] = x;
            left[1] = y - 1;
            list.add(left);
        }
        if (y + 1 < grid[0].length && grid[x][y+1] == 1) {
            left = new int[2];
            left[0] = x;
            left[1] = y + 1;
            list.add(left);
        }
        return list;
    } 
}
