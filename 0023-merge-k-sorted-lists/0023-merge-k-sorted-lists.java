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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);
        ListNode res=temp;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1==null) temp.next=l2;
        if(l2==null) temp.next=l1;
        return res.next;
    }
    
    ListNode mergeSort(ListNode lists[],int low,int high){
        if(low==high) return lists[low];
        if(low>high) return null;
        int mid=low+(high-low)/2;
        ListNode left=mergeSort(lists,low,mid);
        ListNode right=mergeSort(lists,mid+1,high);
        return mergeTwoLists(left,right);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return mergeSort(lists,0,lists.length-1);
    }
}