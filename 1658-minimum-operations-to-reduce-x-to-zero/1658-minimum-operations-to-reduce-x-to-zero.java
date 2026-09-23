class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if(nums[0] > x && nums[n-1] > x) {
            return -1;
        }
        if(n == 1) {
            if(nums[0] == x) return 1;
            else return -1;
        }
        long totalSum = 0;
        for(int num : nums) {
            totalSum += (long)num;
        }
        if(totalSum < x) { //for testcase like [1,1] x=3
            return -1;
        }
        long required = totalSum - x;
        if(required == 0) {//for testcase like [8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309]  x = 134365
            return n; 
        }
        long currSum = 0;
        int len = 0;
        int left=0,right=0;
        while(right < n) {
            currSum += nums[right];

            while(currSum > required) {
                currSum -= nums[left];
                left++;
            }

            if(currSum == required) {
                len = Math.max(len,right-left+1);
            }

            right++;
        }

      //  System.out.println(currSum);

        return len == 0 ? -1 : n-len;
    }
}

