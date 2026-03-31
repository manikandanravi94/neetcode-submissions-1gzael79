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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        for(ListNode node: lists){
          queue.add(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode temp=dummy;

        while(!queue.isEmpty()){
            ListNode remEle =queue.poll();
            temp.next = new ListNode(remEle.val);
            if(remEle.next!=null)
            queue.add(remEle.next);

            temp=temp.next;

        }
        
        return dummy.next;

    }
}
