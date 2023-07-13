class Solution {
    public void reverse(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks) freq[c-'A']++;
        Arrays.sort(freq);
        reverse(freq);
        
        int idle=(freq[0]-1)*n;
        for(int i=1;i<freq.length;i++) idle-=Math.min(freq[0]-1,freq[i]);
        return tasks.length+Math.max(0,idle);
    }
}