/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.*/




class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heightsIn) {
        Grid heights = new Grid(heightsIn);
        ArrayList<List<Integer>> solution = new ArrayList<List<Integer>>();
        int pacific = 0;
        int atlantic = 1;
        for (int x = 0; x < heightsIn.length; x++) {
            for (int y = 0; y < heightsIn[0].length; y++) {
                heights.unVisit();
                boolean foundPacific = dfs(heights.getPoint(x, y), heights, pacific);
                heights.unVisit();
                boolean foundAtlantic = dfs(heights.getPoint(x, y), heights, atlantic);
                if (foundPacific && foundAtlantic) {
                    System.out.println(heights.getPoint(x, y));
                    ArrayList<Integer> coordinate = new ArrayList<Integer>();
                    coordinate.add(x);
                    coordinate.add(y);
                    solution.add(coordinate);
                }
            }
        }
        return solution;
    }
    public boolean dfs(Point start, Grid heights, int ocean) {
        if (ocean == 0 && (start.x == 0 || start.y == 0)) return true;
        if (ocean == 1 && (start.x == heights.grid.length - 1|| start.y == heights.grid[0].length -1)) return true;
        start.visit();
        LinkedList<Point> neighbors = heights.getNeighbors(start);
        if (neighbors.isEmpty()) return false;
        for (Point neighbor : neighbors) {
            neighbor.visit();    
            if (dfs(neighbor, heights, ocean)) return true;
        }
            
        return false;
        
            
    }

    
    private class Point {
        int x;
        int y;
        boolean visited;
        int height;
        
        Point(int xIn, int yIn, int heightIn) {
            this.x = xIn;
            this.y = yIn;
            this.height = heightIn;
            this.visited = false;
        }
        
        private void visit() {
            this.visited = true;
        }
        
        public String toString() {
            String output = "("+ x + ", " + y + ", " + height + ")";
            return output;
        }
    }
    
    private class Grid{
        Point[][] grid;
        Grid(int[][] gridIn) {
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
            if (x - 1 > -1 && grid[x - 1][y].height <= point.height && !grid[x - 1][y].visited) list.add(grid[x - 1][y]);
            if (x + 1 < grid.length && grid[x + 1][y].height <= point.height && !grid[x + 1][y].visited) list.add(grid[x + 1][y]);
            if (y - 1 > -1 && grid[x][y - 1].height <= point.height && !grid[x][y - 1].visited) list.add(grid[x][y - 1]);
            if (y + 1 < grid[0].length && grid[x][y + 1].height <= point.height && !grid[x][y + 1].visited) list.add(grid[x][y + 1]);
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
    }
}
