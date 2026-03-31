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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry=0;
        ListNode temp=dummy;
        while(l1!=null || l2!=null){
            int sum=(l1!=null?l1.val:0) + (l2!=null?l2.val:0)+carry;
            carry=0;
            temp.next=new ListNode(sum%10);
            if(sum>=10){
                carry=1;
            }
            l1=(l1!=null)?l1.next:null;
            l2=(l2!=null)?l2.next:null;
            temp=temp.next;
        }
        if(carry!=0){
          temp.next=new ListNode(1);  
        }
        return dummy.next;
    }
}
