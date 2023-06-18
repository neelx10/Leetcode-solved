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
    public TreeNode solve(int[] preorder,int pstart, int pend,int[] inorder, int instart, int inend,Map<Integer,Integer> map){
        if(pstart>pend || instart>inend) return null;
        TreeNode root=new TreeNode(preorder[pstart]);
        int loc=map.get(root.val);
        int val=loc-instart;
        root.left=solve(preorder,pstart+1,pstart+val,inorder,instart,loc-1,map);
        root.right=solve(preorder,pstart+val+1,pend,inorder,loc+1,inend,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return solve(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
}