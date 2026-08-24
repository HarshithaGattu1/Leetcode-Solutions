class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public int longestSubarray(int[] nums, int k) {
        for(int num : nums) {
            findPrimes(num);
        }

        int maxLen = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0,right=0;
        while(right  < nums.length) {
            for(int val : map.get(nums[right])) {
                hm.put(val,hm.getOrDefault(val,0)+1);
            }
            while(hm.size() > k) {
                for(int val : map.get(nums[left])) {
                    hm.put(val,hm.get(val)-1);
                    if(hm.get(val) == 0) {
                        hm.remove(val);
                    }
                }
                left++;
            }
            maxLen = Math.max(right-left+1,maxLen);
            right++;
        }
        return maxLen;
    }

    public void findPrimes(int num) {
       boolean prime = false;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=2;i<=Math.sqrt(num);i++) {
            if(num % i == 0) {
                int ano = num/i;
                if(ano != i) {
                    prime = isPrime(ano);
                    if(prime) {
                        temp.add(ano);
                    }
                }
                prime = isPrime(i);
                if(prime) {
                   temp.add(i);
                }
            }
        }
        if(isPrime(num)) {
            temp.add(num);
        }
        map.put(num,temp);
    }
    boolean isPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}