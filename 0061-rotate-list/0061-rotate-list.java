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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        int n=1;
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }
        k=k%n;
        k=n-k;
        temp.next=head;
        ListNode prev=new ListNode(-1);
        while(k-- > 0){
            prev=head;
            head=head.next;
        }
        prev.next=null;
        return head;
    }
}