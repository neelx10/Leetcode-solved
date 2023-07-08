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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode oddHead=new ListNode();
        ListNode evenHead=new ListNode();
        ListNode oddTail=oddHead;
        ListNode evenTail=evenHead;
        
        ListNode curr=head;
        int count=0;
        while(curr!=null){
            if(count%2==0){
                oddTail.next=curr;
                oddTail=oddTail.next;
            }
            else{
                evenTail.next=curr;
                evenTail=evenTail.next;
            }
            count++;
            curr=curr.next;
        }
        
        if(oddHead.next==null) return evenHead.next;
        oddTail.next=(evenHead.next==null)?null:evenHead.next;
        if(evenHead.next!=null) evenTail.next=null;
        return oddHead.next;
    }
}