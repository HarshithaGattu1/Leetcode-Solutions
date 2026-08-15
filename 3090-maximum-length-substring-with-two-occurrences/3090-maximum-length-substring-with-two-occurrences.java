class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0, right = 0,n = s.length(),maxLen = 0;
        while(right < n) {
            char ch = s.charAt(right);
           freq[ch-'a']++;
            while(freq[ch-'a'] > 2) {
                int charLeft = s.charAt(left)-'a';
                freq[charLeft]--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }
        return maxLen;
    }
}