class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rem;
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            rem = target - nums[i];
            if (map.containsKey(rem)) {
                output[0] = map.get(rem);
                output[1] = i;
                    return output;
            }
            map.put(nums[i], i);
        }
        return output;
    }
}
