class Solution {
        List<List<Integer>> res = new LinkedList();
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) return res;
            Stack<Integer> stack = new Stack<>();
            helper(stack, 0, nums);
            return res;
        }
        private void helper(Stack<Integer> stack, int index, int[] nums) {
            List<Integer> list = new ArrayList(stack);
            res.add(list);
            for (int i = index; i < nums.length; i++) {
                stack.push(nums[i]);
                helper(stack, i + 1, nums);       
                stack.pop();
            }
        }
}
