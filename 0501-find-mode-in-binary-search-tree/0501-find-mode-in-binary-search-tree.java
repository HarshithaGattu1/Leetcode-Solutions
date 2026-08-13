/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int maxFreq = 1;
    int count = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) {
            return new int[]{};
        }
        countNodes(root);
        int i=0;
        int[] ans = new int[count];
        for(int key : map.keySet()) {
            if(map.get(key) == maxFreq) {
                ans[i++] = key;
            }
        }
        return ans;
    }
    public  void countNodes(TreeNode root) {
        if(root == null) {
            return;
        }
        int data = root.val;
        map.put(data,map.getOrDefault(data,0)+1);
        //maxFreq = Math.max(maxFreq,map.get(data));
        if(map.get(data) >= maxFreq) {
            if(map.get(data) > maxFreq) {
                count = 1;
                maxFreq = map.get(data);
            }
            else {
                count++;
            }
        }
        
        countNodes(root.left);
        countNodes(root.right);
    }
}