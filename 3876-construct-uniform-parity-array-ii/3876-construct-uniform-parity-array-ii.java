class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int evencnt = 0,oddcnt = 0;
        for(int i=0;i<n;i++) {
            if(nums1[i] % 2 == 0) evencnt++;
            else oddcnt++;
        }
        if(evencnt == n || oddcnt == n) return true;
        Arrays.sort(nums1);
        if(nums1[0] % 2 == 0) return false;
        return true;
    }
}