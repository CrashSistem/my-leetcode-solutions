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
    public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root != null) {
                searchPaths(root, "", result);
                return result;
            }
            return result;
        }

        void searchPaths(TreeNode root, String path, List<String> result) {
            path += root.val;

            if (root.left == null && root.right == null) {
                result.add(path);
                return;
            }

            if (root.left != null) {
                searchPaths(root.left, path + "->", result);
            }
            if (root.right != null) {
                searchPaths(root.right, path + "->", result);
            }
        }
}
