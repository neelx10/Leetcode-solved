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
    int prev=-1,min=(int)1e9;
    public int minDiffInBST(TreeNode node) {
        if (node == null) return min;

        minDiffInBST(node.left);
        if(prev!=-1) min = Math.min(min, node.val - prev);
        prev = node.val;
        minDiffInBST(node.right);

        return min;
     }
}