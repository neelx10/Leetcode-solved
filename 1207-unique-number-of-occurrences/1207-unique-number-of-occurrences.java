class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] A=new int[2001];
        for(int i=0;i<arr.length;i++) A[1000+arr[i]]++;
        Arrays.sort(A);
        for(int i=1;i<2001;i++){
            if(A[i]!=0 && A[i]==A[i-1]) return false;
        }
        return true;
    }
}