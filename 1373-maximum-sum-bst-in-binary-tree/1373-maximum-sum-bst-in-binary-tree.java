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
class Tuple{
    int size,max,min;
    Tuple(int size,int max,int min){
        this.size=size;
        this.min=min;
        this.max=max;
    }
}
class Solution {
    int maxi=0;
    public Tuple maxSum(TreeNode root){
        if(root==null) return new Tuple(0,(int)-1e9,(int)1e9);
        Tuple left=maxSum(root.left);
        Tuple right=maxSum(root.right);
        if(left.max<root.val && root.val<right.min){
            maxi=Math.max(maxi,root.val+left.size+right.size);
            return new Tuple(root.val+left.size+right.size,Math.max(root.val,right.max),Math.min(root.val,left.min));
        }
        else return new Tuple(Math.max(left.size,right.size),(int)1e9,(int)-1e9);
    }
    public int maxSumBST(TreeNode root) {
        maxSum(root);
        return maxi;
    }
}