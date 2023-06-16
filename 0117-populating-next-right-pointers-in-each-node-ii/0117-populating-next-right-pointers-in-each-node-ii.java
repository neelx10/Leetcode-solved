/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            while(n-- > 0){
                Node n1=q.poll();
                if(!q.isEmpty()) n1.next=q.peek();
                if(n1.left!=null) q.offer(n1.left);
                if(n1.right!=null) q.offer(n1.right);
                if(n==0) n1.next=null;
            }
        }
        return root;
    }
}