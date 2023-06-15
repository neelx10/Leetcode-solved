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
    public List<Long> maxLevelSum(TreeNode root) {
        List<Long> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len=q.size();
            long sum=0;
            while(len-- > 0){
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            list.add(sum);
        }
        return list;
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> arr=maxLevelSum(root);
        Collections.sort(arr);
        if(arr.size()-k < 0) return -1;
        return arr.get(arr.size()-k);
    }
}