/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int search(int[] nums, int target) {
        int index = nums.length / 2;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[index] == target) return index;
            else if (nums[index] > target) r = index - 1;
            else if (nums[index] < target) l = index + 1;
            index  = (l + r) / 2;
        }
        return -1;
    }
}
