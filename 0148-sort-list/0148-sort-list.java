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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val>list2.val){
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }
        ListNode res=list1;
        while(list1!=null && list2!=null){
            ListNode temp=null;
            while(list1!=null && list1.val<=list2.val){
                temp=list1;
                list1=list1.next;
            }
            temp.next=list2;
            //swapping
            ListNode tmp=list1;
            list1=list2;
            list2=tmp;
        }
        return res;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        //finding middle of LL
        ListNode temp=null,slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        temp.next=null;
        
        //recursive calls
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        
        //merging the 2 sorted LL's
        return mergeTwoLists(l1,l2);
    }
}