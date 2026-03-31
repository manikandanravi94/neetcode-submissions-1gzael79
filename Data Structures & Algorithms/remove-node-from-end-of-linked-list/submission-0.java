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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next=head;
        ListNode temp=dummy;
        ListNode fast=dummy;
        int i=0;
        while(i<=n){
            fast=fast.next;
            i=i+1;
        }

        while(fast!=null){
            temp=temp.next;
            fast=fast.next;
        }
        if(temp.next!=null)
        temp.next=temp.next.next;
        return dummy.next;

    }
}
