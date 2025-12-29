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
    public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int h = height(root);
            if (height(root.right) == h - 1) return (1 << h) + countNodes(root.right);
            return (1 << (h - 1)) + countNodes(root.left);

        }
        int height(TreeNode node) {
            return (node == null) ? -1  : 1 + height(node.left);
        }
}
