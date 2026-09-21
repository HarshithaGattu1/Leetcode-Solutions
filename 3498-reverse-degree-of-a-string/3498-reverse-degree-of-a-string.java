class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            int pro = (122-s.charAt(i)+1) * (i+1);
            sum += pro;
        }
        return sum;
    }
}