class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        for (int n = 2; n < size; n++) {
            if (cost[n - 1] < cost[n - 2]) {
                cost[n] += cost[n - 1];
            }
            else {
                cost[n] += cost[n - 2];
            }
        }
        
        if (cost[size - 1] < cost[size - 2]) {
            return cost[size - 1];
        }
        else {
            return cost[size - 2];
        }
    }
}
