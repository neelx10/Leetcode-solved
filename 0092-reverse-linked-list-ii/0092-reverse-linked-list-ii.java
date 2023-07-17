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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        dummy.next = head;

        for (int i = 1; i < left; i++) prev = prev.next;

        ListNode curr = prev.next;
        ListNode fw = curr;
        ListNode temp = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = temp;
            temp = curr;
            curr = next;
        }

        prev.next = temp;
        fw.next = curr;

        return dummy.next;
    }
}