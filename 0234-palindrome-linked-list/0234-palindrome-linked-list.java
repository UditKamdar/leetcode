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
        if(head == null) return true;
        if(head.next == null) return true;

        ListNode mid = findMid(head);
        ListNode endNode = reverse(mid.next);

        ListNode startNode = head;

        while(endNode != null){
            if(startNode.val != endNode.val) return false;
            startNode = startNode.next;
            endNode = endNode.next;
        }
        return true;
    }

    ListNode findMid(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

     ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}