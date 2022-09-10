/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

*/





class Solution {
    public int numIslands(char[][] gridIn) {
        Grid grid = new Grid(gridIn);
        int count = 0;
        for (int x = 0; x < gridIn.length; x++) {
            for (int y = 0; y < gridIn[0].length; y++) {
                if (bfs(x, y, grid)) count++;
            }
        }
        return count;
    }
    
    public boolean bfs(int x, int y, Grid grid) {
        Point start = grid.getPoint(x, y);
        if (start.visited || start.land == '0') return false;
        LinkedList<Point> queue = new LinkedList<Point>();
        start.visited = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            curr.visit();
            LinkedList<Point> neighbors = grid.getNeighbors(curr);
            for (Point neighbor : neighbors) {
                if (!neighbor.visited && neighbor.land == '1') {
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }

        }
        return true;
    }
    

    
    private class Point {
        int x;
        int y;
        boolean visited;
        char land;
        
        Point(int xIn, int yIn, char landIn) {
            this.x = xIn;
            this.y = yIn;
            this.land = landIn;
            this.visited = false;
        }
        
        private void visit() {
            this.visited = true;
        }
    }
    
    private class Grid{
        Point[][] grid;
        Grid(char[][] gridIn) {
            this.grid = new Point[gridIn.length][gridIn[0].length];
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    grid[x][y] = new Point(x, y, gridIn[x][y]);
                }
            }
        }
        
        public LinkedList<Point> getNeighbors(Point point) {
            LinkedList<Point> list = new LinkedList<Point>();
            int x = point.x;
            int y = point.y;
            if (x - 1 > -1) list.add(grid[x - 1][y]);
            if (x + 1 < grid.length) list.add(grid[x + 1][y]);
            if (y - 1 > -1) list.add(grid[x][y - 1]);
            if (y + 1 < grid[0].length) list.add(grid[x][y + 1]);
            return list;
        }
        
        public Point getPoint(int x, int y) {
            return grid[x][y];
        }  
    }
}
