//Given an integer array nums, return true 
//if any value appears at least twice in the array, 
//and return false if every element is distinct.
import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        Collections.addAll(set, nums);
        if (set.size() != nums.length) {
            return true;
        }
        return false;
    }
}
