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
    public TreeNode bst(int num,TreeNode root){
        TreeNode cur=root,prev=root;
        while(cur!=null){
            prev=cur;
            if(num>cur.val) cur=cur.right;
            else cur=cur.left;
        }
        if(num<prev.val) prev.left=new TreeNode(num);
        else prev.right=new TreeNode(num);
        return root;
    }
    public TreeNode bstFromPreorder(int[] nums) {
        TreeNode root=new TreeNode(nums[0]);
        for(int i=1;i<nums.length;i++) root=bst(nums[i],root);
        return root;
    }
}