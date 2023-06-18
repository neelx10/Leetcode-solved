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
    public void assign_parent(Map<TreeNode,TreeNode> map, TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.left!=null){
                map.put(temp.left,temp);
                q.offer(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right,temp);
                q.offer(temp.right);
            }
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        assign_parent(map,root);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        Set<TreeNode> visited=new HashSet<>();
        visited.add(target);
        int count=0;
        while(!q.isEmpty()){
            if(count==k) break;
            count++;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left!=null && !visited.contains(temp.left)){
                    visited.add(temp.left);
                    q.offer(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)){
                    visited.add(temp.right);
                    q.offer(temp.right);
                }
                if(map.containsKey(temp) && !visited.contains(map.get(temp))){
                    visited.add(map.get(temp));
                    q.offer(map.get(temp));
                }
            }
        }
        
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()) list.add(q.poll().val);
        return list;
    }
}