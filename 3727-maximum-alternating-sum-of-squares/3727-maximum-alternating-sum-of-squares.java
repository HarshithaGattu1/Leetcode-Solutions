class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] < 0) nums[i] *= -1;
        }
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<=j) {
            if(i==j) sum += nums[i]*nums[i];
            else sum += nums[j]*nums[j] - nums[i]*nums[i];
            i++;
            j--;
        }
        return sum;
    }
}