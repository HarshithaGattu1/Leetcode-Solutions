class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0,n = s.length(),maxLen = 0;
        while(right < n) {
            char key = s.charAt(right);
            map.put(key,map.getOrDefault(key,0)+1);
            while(map.get(key) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}