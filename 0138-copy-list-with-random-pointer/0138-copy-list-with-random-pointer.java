/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //copy of each node and inserting after original nodes
        Node iter=head,front=head;
        while(iter!=null){
            front=iter.next;
            Node new_node=new Node(iter.val);
            iter.next=new_node;
            new_node.next=front;
            iter=front;
        }

        //assigning the random pointers
        iter=head;
        while(iter!=null){
            if(iter.random!=null) iter.next.random=iter.random.next;
            iter=iter.next.next;
        }

        //segregating the cloned and the old LL
        Node dummy=new Node(0);
        Node temp=dummy;
        iter=head;
        while(iter!=null){
            front=iter.next.next;
            temp.next=iter.next;
            temp=temp.next;
            iter.next=front;
            iter=front;
        }

        return dummy.next;
    }
}














