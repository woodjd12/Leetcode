/*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
*/


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<LinkedList<Integer>> array = new ArrayList<LinkedList<Integer>>(numCourses);
        int[] output = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> stack = new Stack<Integer>();
        int destination;
        int source;
        for (int i = 0; i < numCourses; i++) array.add(new LinkedList<Integer>());
        for (int x = 0; x < prerequisites.length; x++) {
            source = prerequisites[x][0];
            destination = prerequisites[x][1];
            array.get(source).add(destination);
        }
        for (int x = 0; x < numCourses; x++) {
            if(!topSort(x, array, visited, recStack, stack)) return new int[0];
        }
        int i = numCourses - 1;
        while (!stack.isEmpty()) {
            output[i] = stack.pop();
            i--;
        }
        return output;
    }

    public boolean topSort(int index, ArrayList<LinkedList<Integer>> array, boolean[] visited, boolean[] recStack, Stack<Integer> stack) {
        if (recStack[index]) return true;
        if (visited[index]) return false;
        visited[index] = true;
        if (array.get(index).isEmpty()) {
            stack.push(index);
            recStack[index] = true;
            return true;
        }
        for (int child : array.get(index)) if (!topSort(child, array, visited, recStack, stack)) return false;
        visited[index] = false;
        recStack[index] = true;
        stack.push(index);
        return true;
    }
}
