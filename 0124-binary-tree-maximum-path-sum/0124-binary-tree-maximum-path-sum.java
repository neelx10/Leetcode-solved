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
    int maxi=(int)-1e9;
    public int maxSum(TreeNode node){
		if(node==null) return 0;
		int left=Math.max(0,maxSum(node.left));
		int right=Math.max(0,maxSum(node.right));
		maxi=Math.max(maxi,left+right+node.val);
		return node.val+Math.max(left,right);
	}
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxi;
    }
}