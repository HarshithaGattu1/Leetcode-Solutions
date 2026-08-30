class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(0,new ArrayList<>(),nums);
        return ans;
    }
    void findSubsets(int ind,List<Integer> ds,int[] nums) {
        if(ind == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[ind]);
        findSubsets(ind+1,ds,nums);
        ds.remove(ds.size()-1);
        findSubsets(ind+1,ds,nums);
    }
}