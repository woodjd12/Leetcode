/*Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<Integer> pStack = new Stack<Integer>();
        Stack<Integer> qStack = new Stack<Integer>();
        dfs(p, pStack);
        dfs(q, qStack);
        if (pStack.equals(qStack)) return true;
        return false;
    }
    
    private void dfs(TreeNode root, Stack stack) {
        if (root == null) {
            stack.push(null);
            return;
        }
        stack.push(root.val);
        dfs(root.left, stack);
        dfs(root.right, stack);
    }
}
