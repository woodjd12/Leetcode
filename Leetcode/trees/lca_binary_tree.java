/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stackp = new Stack<TreeNode>();
        dfs(root, p, stackp);
        Stack<TreeNode> stackq = new Stack<TreeNode>();
        dfs(root, q, stackq);
        TreeNode lcaNode = null;
        while (!stackp.empty()) {
            TreeNode val = stackp.pop();
            if (stackq.search(val) != -1) 
                lcaNode = val;      
        }
        return lcaNode;
    }
    private boolean dfs(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null) return false;
        if (root.val == target.val)  {
            stack.push(root);
            return true;
        }
        if (dfs(root.left, target, stack)) {
            stack.push(root);
            return true;
        }
        if (dfs(root.right, target, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }
}
