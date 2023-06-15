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
    public int maxLevelSum(TreeNode root) {
        int maxi=(int)-1e9;
        int ans=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty()){
            int len=q.size();
            int sum=0;
            while(len-- > 0){
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            if(sum>maxi){
                maxi=sum;
                ans=level;
            }
            level++;
        }
        return ans;
    }
}