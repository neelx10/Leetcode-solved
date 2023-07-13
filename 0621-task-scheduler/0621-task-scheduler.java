class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] freq=new Integer[26];
        Arrays.fill(freq,0);
        for(char c:tasks) freq[c-'A']++;
        Arrays.sort(freq, Collections.reverseOrder());
        
        int idle=(freq[0]-1)*n;
        for(int i=1;i<freq.length;i++) idle-=Math.min(freq[0]-1,freq[i]);
        return tasks.length+Math.max(0,idle);
    }
}