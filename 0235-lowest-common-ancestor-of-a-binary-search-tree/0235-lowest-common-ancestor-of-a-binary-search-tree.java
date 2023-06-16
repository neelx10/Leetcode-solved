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
        // if(root==null) return null;
        // if(root.val<p.val && root.val<q.val) lowestCommonAncestor(root.right,p,q);
        // if(root.val>p.val && root.val>q.val) lowestCommonAncestor(root.left,p,q);
        // return root;
        while(root!=null){
            if(root.val<p.val && root.val<q.val) root=root.right;
            else if(root.val>p.val && root.val>q.val) root=root.left;
            else break;
        }
        return root;
    }
}