class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int N = Math.max(arr1.length, arr2.length);

        for(int i = 0; i < N; i++){
            
            if(i < arr1.length && i < arr2.length){
                int n1 = Integer.parseInt(arr1[i]);
                int n2 = Integer.parseInt(arr2[i]);
                
                if(n1 < n2){
                    return -1;
                }
                if(n1 > n2){
                    return 1;
                }
            }else{
                if(i >= arr1.length){
                    int n1 = 0;
                    int n2 = Integer.parseInt(arr2[i]);

                    if(n1 < n2){
                        return -1;
                    }
                    if(n1 > n2){
                        return 1;
                    }
                }else if(i >= arr2.length){
                    int n1 = Integer.parseInt(arr1[i]);
                    int n2 = 0;

                    if(n1 < n2){
                        return -1;
                    }
                    if(n1 > n2){
                        return 1;
                    }
                }
            }
        }

        return 0;
    }
}