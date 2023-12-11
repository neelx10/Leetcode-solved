class Solution {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;
        int freq=1;
        if(n==1) return arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]) freq++;
            else freq=1;
            if(freq>(n/4)) return arr[i];
        }
        return -1;
    }
}