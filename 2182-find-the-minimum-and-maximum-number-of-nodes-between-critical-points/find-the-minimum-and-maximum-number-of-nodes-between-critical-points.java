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
class Solution{
    public int[] nodesBetweenCriticalPoints(ListNode head){
        if(head==null || head.next==null || head.next.next==null) return new int[]{-1,-1};
        ListNode curr=head.next,prev=head;
        int firstCriticIdx=-1,lastCriticIdx=-1;
        int currIdx=1;
        int minDist=10000000;
        while(curr.next!=null){
            ListNode nxt=curr.next;
            if((prev.val<curr.val && curr.val>nxt.val)||(prev.val>curr.val && curr.val<nxt.val)){
                if(firstCriticIdx==-1){
                    firstCriticIdx=currIdx;
                }else{
                    minDist=Math.min(minDist,currIdx-lastCriticIdx);
                }
                lastCriticIdx=currIdx;
            }
            prev=curr;
            curr=curr.next;
            currIdx++;
        }
        if(firstCriticIdx==-1 || firstCriticIdx==lastCriticIdx) return new int[]{-1,-1};
        return new int[]{minDist,lastCriticIdx-firstCriticIdx};
    }
}