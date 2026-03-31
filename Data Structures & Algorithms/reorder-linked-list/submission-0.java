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
    public void reorderList(ListNode head) {
        if(head ==null || head.next==null || head.next.next==null){
            return;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        ListNode prev=null;
        ListNode curr=mid;
        while(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        
        
        ListNode l1=head;
        ListNode l2=prev;

        while(l2!=null){
         ListNode nextL1 = l1.next;
         ListNode nextL2=l2.next;

         l1.next=l2;
         l2.next=nextL1;

         l1=nextL1;
         l2=nextL2;
        }

    }
}
