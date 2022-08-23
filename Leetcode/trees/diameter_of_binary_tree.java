/*Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.*/



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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int diameter = depth(root.left) + depth(root.right);
        int children = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        if (diameter > children) return diameter;
        else return children;
        
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int depth = Math.max(depth(root.left), depth(root.right));
        depth++;
        return depth;
    }
}
