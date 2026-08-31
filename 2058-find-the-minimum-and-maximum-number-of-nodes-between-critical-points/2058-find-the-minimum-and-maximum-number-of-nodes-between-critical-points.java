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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        int ind = 1;
        ListNode temp = head;
        int prev = head.val;
        while(temp.next != null) {
            if(temp.val < prev && temp.val<temp.next.val) {
                list.add(ind);
            }
            if(temp.val > prev && temp.val>temp.next.val) {
                list.add(ind);
            }
            prev = temp.val;
            ind++;
            temp = temp.next;
        }
        //System.out.println(list);
        if(list.size() == 0) {
            return new int[]{-1,-1};
        }
        int[] ans = new int[2];
        int minDis = Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++) {
            minDis = Math.min(minDis,list.get(i+1)-list.get(i)); 
        }
        if(minDis == Integer.MAX_VALUE) {
            return new int[]{-1,-1};
        }
        ans[0] = minDis;
        ans[1] = list.get(list.size()-1)-list.get(0);
        return ans;       
    }
}