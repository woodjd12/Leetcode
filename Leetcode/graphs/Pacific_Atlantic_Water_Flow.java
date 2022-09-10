/*There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
*/
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
