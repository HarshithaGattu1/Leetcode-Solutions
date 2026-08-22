class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = calSumAndPro(temp);
        return n%sum == 0;
    }

    int calSumAndPro(int n) {
        int sum = 0;
        int pro = 1;
        while(n > 0) {
            int dig = n%10;
            sum += dig;
            pro *= dig;
            n /= 10;
        }
        return sum+pro;
    }
}