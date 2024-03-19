class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char ch: tasks){
            freq[ch - 'A']++;
            maxFreq = Math.max(freq[ch - 'A'], maxFreq);
        }

        int maxCount = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] == maxFreq){
                maxCount++;
            }
        }

        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}