class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) { 
            return nums[0];
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            }
            else {
                return nums[1];
            }
        }
        nums[2] += nums[0];
        for (int i = 3; i < nums.length; i++) {
            if (nums[i - 2] > nums[i - 3]) {
                nums[i] = nums[i] + nums[i - 2];
            }
            else {
                nums[i] = nums[i] + nums[i - 3];
            }
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        else {
            return nums[nums.length - 2];
        }
            
    }
}
