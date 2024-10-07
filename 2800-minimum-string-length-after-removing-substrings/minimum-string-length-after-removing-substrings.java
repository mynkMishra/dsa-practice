class Solution {
    public int minLength(String s) {
        int N = s.length();

        LinkedList<Character> st = new LinkedList<Character>();

        int r = 0;
        while(r < N){
            if(st.size() < 1){
                st.addLast(s.charAt(r));
                r++;
            }else{
                char ch2 = s.charAt(r);
                char ch1 = st.peekLast();

                if((ch1 == 'A' && ch2 == 'B') || (ch1 == 'C' && ch2 == 'D')){
                    st.removeLast();
                }else{
                    st.addLast(ch2);
                }
                r++;
            }
        }

        return st.size();
    }
}