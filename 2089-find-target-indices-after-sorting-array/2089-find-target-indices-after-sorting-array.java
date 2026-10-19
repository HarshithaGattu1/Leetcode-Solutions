class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessThanTargetCount = 0;
        int targetCount = 0;
        for(int num : nums) {
            if(num < target) {
                lessThanTargetCount++;
            }
            if(num == target) {
                targetCount++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int startingIndexOfTarget = lessThanTargetCount++;
        while(targetCount > 0) {
            ans.add(startingIndexOfTarget);
            targetCount--;
            startingIndexOfTarget++;
        }
        return ans;
    }
}