class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int i=0,n=s.length();
        // while(i < n) {
        //     if(s.charAAt(i) == '(') {
        //         break;
        //     }
        //     res.append(s.charAt(i));
        //     i++;
        // }
        // if(i == n) {
        //     return res.toString();
        // }
        int open = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(open == 0 && ch != '(') {
                res.append(s.charAt(i));
            }
            else if(ch == '(') {
                st.push(ch);
                open++;
            }
            else if(ch != ')') {
                st.push(ch);
            }
            else {
                StringBuilder temp = new StringBuilder();
                while(st.peek() != '(') {
                    temp.append(st.pop());
                }
                st.pop();
                open--;
                if(open == 0) {
                    res.append(temp);
                }
                else {
                    int j = 0;
                    while(j < temp.length()) {
                        st.push(temp.charAt(j));
                        j++;
                    }
                }
            }
            i++;

        }
        return res.toString();
    }
}