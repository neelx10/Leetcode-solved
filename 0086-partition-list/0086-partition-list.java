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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1),large=new ListNode(-1);
        ListNode s=small,l=large;

        while(head!=null){
            if(head.val<x){
                s.next=head;
                s=s.next;
            }
            else{
                l.next=head;
                l=l.next;
            }
            head=head.next;
        }

        s.next=large.next;
        l.next=null;
        return small.next;
    }
}