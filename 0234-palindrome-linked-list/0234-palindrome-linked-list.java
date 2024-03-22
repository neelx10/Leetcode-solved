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
    public boolean isPalindrome(ListNode head) { 
        if(head==null || head.next==null) return true;

        ListNode slow=head,fast=head,temp=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next=reverseLL(slow.next);
        slow=slow.next;

        while(slow!=null){
            if(slow.val!=temp.val) return false;
            slow=slow.next;
            temp=temp.next;
        }
        return true;
    }

    public ListNode reverseLL(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}