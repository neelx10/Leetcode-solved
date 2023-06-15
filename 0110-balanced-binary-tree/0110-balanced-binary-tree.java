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
    public boolean isBalanced(TreeNode root) {
        return balTree(root)!=-1;
    }
    public int balTree(TreeNode root){
        if(root==null){return 0;}
        int l=balTree(root.left);
        int r=balTree(root.right);
        if((l==-1||r==-1) || (l>1+r || r>1+l)) return -1;
        return 1+Math.max(l,r);
    }
}