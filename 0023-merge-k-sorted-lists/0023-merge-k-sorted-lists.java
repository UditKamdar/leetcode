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
       if(lists == null || lists.length == 0) return null;
       // -- > Using Heap ( PriorityQueue)

       PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if(node.next != null){
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}


// --> Using Merge Sort
    //    return mergeSort(lists,0,lists.length-1);      
    // }

    // public ListNode mergeSort(ListNode[] lists, int start, int end){
    //     if(start == end) return lists[start];

    //     int mid = start + (end-start)/2;
    //     ListNode left = mergeSort(lists,start,mid);
    //     ListNode right = mergeSort(lists,mid+1,end);

    //     return mergeTwoListNode(left,right);
    // }

    // public ListNode mergeTwoListNode(ListNode l1, ListNode l2){
    //     if(l1 == null && l2 == null) return null;
    //     if(l1 == null ) return l2;
    //     if(l2 == null) return l1;

    //     ListNode head = new ListNode(0);
    //     ListNode dummy = head;

    //     while(l1!= null && l2!=null){
    //         if(l1.val <= l2.val){
    //             dummy.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             dummy.next = l2;
    //             l2 = l2.next;
    //         }
    //         dummy = dummy.next;
    //     }

    //     if(l1 != null) dummy.next = l1;
    //     if(l2 != null) dummy.next = l2;

    //     return head.next;
    // }
//}
