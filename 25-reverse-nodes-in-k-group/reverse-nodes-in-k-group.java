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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Check if there are at least k nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If less than k nodes, return as it is
        if (count < k) return head;

        // Reverse first k nodes
        ListNode prev = null;
        curr = head;
        ListNode next = null;
        count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // head is now the last node of the reversed group
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this group
        return prev;
    }
}

// class Solution {
//     public ListNode getKthNode(ListNode temp,int k){
//         k-=1;
//         while(k>0 && temp!=null){
//             temp=temp.next;
//             k--;
//         }
//         return temp;
//     }
//     public ListNode reverseList(ListNode head) {
//         ListNode curr=head,prev=null;
//         while(curr!=null){
//             ListNode nxt=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=nxt;
//         }
//         return prev;
//     }
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode temp=head,prevLast=null,nextNode=null;

//         while(temp!=null){
//             ListNode kthNode=getKthNode(temp,k);
//             if(kthNode==null){      //If doesnt have k nodes at last
//                 if(prevLast!=null) prevLast.next=temp;
//                 break;
//             }

//             nextNode=kthNode.next;  //Preserve next node before cutting and reversing
//             kthNode.next=null;
//             reverseList(temp);
//             if(head==temp){
//                 head=kthNode;   //if it is first group kth node is always new head
//             }else{
//                 prevLast.next=kthNode;
//             }
//             prevLast=temp;
//             temp=nextNode;
//         }
//         return head;
//     }
// }