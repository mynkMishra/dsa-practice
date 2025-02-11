class Solution {
    public String removeOccurrences(String s, String part) {
       

        while(true){
            int l = 0;
            int r = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            boolean found = false;
            while(r <= s.length()){
                if(r - l < part.length()){
                    r++;
                }else{
                    if(s.substring(l, r).equals(part)){
                        list.add(l);
                        l = r;
                        r += part.length();
                        found = true;
                    }else{
                        l++;
                        r++;
                    }
                }
            }

            if(!found){
                break;
            }

            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(i < s.length()){
                if(list.get(0) != i){
                    sb.append(s.charAt(i));
                    i++;
                }else{
                    i += part.length();
                }
            }

            s = sb.toString();
        }

        return s;
    }
}