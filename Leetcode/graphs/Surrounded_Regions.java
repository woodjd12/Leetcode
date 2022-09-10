/*
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

*/



class Solution {
    public void solve(char[][] boardIn) {
        Grid board = new Grid(boardIn);
        int addy;
        int addx;
        if (boardIn[0].length == 1) addy = 1;
        else addy = boardIn[0].length - 1;
        if (boardIn.length == 1) addx = 1;
        else addx = boardIn.length - 1;
        for (int y = 0; y < boardIn[0].length; y += addy) {
            for (int x = 0; x < boardIn.length; x++) {
                Point curr = board.getPoint(x, y);
                if (curr.open && !curr.visited) bfs(curr, board);
            }
        }
        for (int i = 0; i < boardIn.length; i += addx) {
            for (int j = 0; j < boardIn[0].length; j++) {
                Point curr = board.getPoint(i, j);
                if (curr.open && !curr.visited) bfs(curr, board);
            }
        }
        
        char[][] printBoard = board.printGrid();
        for (int x = 0; x < boardIn.length; x++) {
            for (int y = 0; y < boardIn[0].length; y++) {
                boardIn[x][y] = printBoard[x][y];
            }
        }     
    }
    public void bfs(Point start, Grid board) {
        LinkedList<Point> queue = new LinkedList<Point>();
        int edge = board.grid.length - 1;
        queue.add(start);
        start.visit();
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            curr.captured = false;
            LinkedList<Point> neighbors = board.getNeighbors(curr);
            for (Point neighbor : neighbors) {
                queue.add(neighbor);
                neighbor.visit();
            }
        }
    }
    
    private class Point {
        int x;
        int y;
        boolean visited;
        boolean open;
        boolean captured;
        
        Point(int xIn, int yIn, char openIn) {
            this.x = xIn;
            this.y = yIn;
            if (openIn == 'X') this.open = false;
            else this.open = true;
            this.visited = false;
            this.captured = true;
        }
        
        private void visit() {
            this.visited = true;
        }
        
        public String toString() {
             String output = "("+ x + ", " + y + ", " + open + ")";
            return output;
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
            if (x - 1 > -1 && grid[x - 1][y].open && !grid[x - 1][y].visited) list.add(grid[x - 1][y]);
            if (x + 1 < grid.length && grid[x + 1][y].open && !grid[x + 1][y].visited) list.add(grid[x + 1][y]);
            if (y - 1 > -1 && grid[x][y - 1].open && !grid[x][y - 1].visited) list.add(grid[x][y - 1]);
            if (y + 1 < grid[0].length && grid[x][y + 1].open && !grid[x][y + 1].visited) list.add(grid[x][y + 1]);
            return list;
        }
        
        public Point getPoint(int x, int y) {
            return grid[x][y];
        }
        
        public void unVisit() {
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    grid[x][y].visited = false;
                }
            }
        }
        
        public char[][] printGrid() {
            char[][] board = new char[grid.length][grid[0].length];
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (!grid[x][y].captured) board[x][y] = 'O';
                    else board[x][y] = 'X';                                 
                }
            }
            return board;
        }
    }
}
