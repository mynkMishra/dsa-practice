class Solution {
    public String simplifyPath(String path) {
        
        String[] names = path.split("/", Integer.MAX_VALUE);
        LinkedList<String> stack = new LinkedList<String>();

        for(String name: names){
            if(name.length() > 0){
                if(name.equals("..")){
                    if(stack.size() > 0){
                        stack.removeLast();
                    }
                }else{
                    if(!name.equals(".")){
                        stack.addLast(name);
                    }
                }
            }
            
        }

        StringBuffer sb = new StringBuffer();

        while(stack.size() > 0){
            sb.append("/" + stack.removeFirst());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}