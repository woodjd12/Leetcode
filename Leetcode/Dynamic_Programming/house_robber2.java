class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int len = nums.length;
        int[] copy = Arrays.copyOf(nums, len);
        nums[2] += nums[0];
        copy[3] += copy[1];
        for (int i = 3; i < nums.length - 1; i++) {
            int j = i + 1;
            copy[j] += Math.max(copy[j - 2], copy[j - 3]);
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }
        int copyMax = Math.max(copy[len - 2], copy[len - 1]);
        int numsMax = Math.max(nums[len - 3], nums[len - 2]);
        return Math.max(copyMax, numsMax);
    }
}
