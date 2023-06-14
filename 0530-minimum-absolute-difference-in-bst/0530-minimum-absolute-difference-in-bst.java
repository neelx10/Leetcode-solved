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
      int prev = -1, min = (int)1e9;
      public int getMinimumDifference(TreeNode node) {
        if (node == null) return min;

        getMinimumDifference(node.left);
        if(prev!=-1) min = Math.min(min, node.val - prev);
        prev = node.val;
        getMinimumDifference(node.right);

        return min;
      }
}