class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
            if(nums[i] < 0) {
                nums[i] *= -1;
            }
            maxValue = Math.max(maxValue,nums[i]);
        }

        int[] freq = new int[maxValue+1];
        for(int num : nums) {
            freq[num]++;
        }

        int negative = n/2;
        int positive = n-negative;

        int i=maxValue;
        long ans = 0;
        while(positive > 0) {
            while(freq[i] > 0 && positive > 0) {
                ans += (long)i*i;
                freq[i]--;
                positive--;
            }
            if(freq[i] == 0) 
                i--;
        }

        while(i >= 0) {
            while(freq[i] > 0) {
                ans -= (long)i*i;
                freq[i]--;
            }
            if(freq[i] == 0) 
                i--;
        }

        return ans;

    }
}