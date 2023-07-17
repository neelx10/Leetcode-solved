/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> st1=new Stack<>();
        Stack<ListNode> st2=new Stack<>();
        while(l1!=null){
            st1.push(l1);
            l1=l1.next;
        }
        while(l2!=null){
            st2.push(l2);
            l2=l2.next;
        }
        
        ListNode dummy=new ListNode(-1);
        int carry=0;
        while(!st1.isEmpty() || !st2.isEmpty() || carry==1){
            int sum=0;
            if(!st1.isEmpty()) sum+=st1.pop().val;
            if(!st2.isEmpty()) sum+=st2.pop().val;
            sum+=carry;
            carry=sum/10;
            ListNode newNode=new ListNode(sum%10);
            if(dummy.val==-1) dummy=newNode;
            else{
                newNode.next=dummy;
                dummy=newNode;
            }
        }
        return dummy;
    }
}