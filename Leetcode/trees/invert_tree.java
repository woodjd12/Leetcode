// Given the root of a binary tree, invert the tree, and return its root.





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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode curr = root;
        TreeNode next;
        next = curr.left;
        curr.left = curr.right;
        curr.right = next;
        invertTree(curr.left);
        invertTree(curr.right);
        return root;
    }
}
