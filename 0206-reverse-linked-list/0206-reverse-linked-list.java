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
    public ListNode reverseList(ListNode head) {
        ListNode curr=head,th=null;
        while(curr!=null){
            ListNode fw=curr.next;
            curr.next=null;
            if(th==null) th=curr;
            else{
                curr.next=th;
                th=curr;
            }
            curr=fw;
        }
        return th;
    }
}