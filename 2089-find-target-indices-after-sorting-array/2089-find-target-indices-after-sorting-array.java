class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] freq = new int[101];
        int max = -1;
        for(int num : nums) {
            freq[num]++;
            max = Math.max(max,num);
        }
        int countLessThanTarget = 0;
        int countOfTarget = -1;
        for(int i=1;i<=max;i++) {
            if(i != target) {
                countLessThanTarget += freq[i];
            }
            else {
                countOfTarget = freq[i];
                break;
            }
        }

        int startIndexOfTarget = countLessThanTarget;
        List<Integer> ans = new ArrayList<>();
        while(countOfTarget > 0) {
            ans.add(startIndexOfTarget);
            startIndexOfTarget++;
            countOfTarget--;
        }
        return ans;
    }
}