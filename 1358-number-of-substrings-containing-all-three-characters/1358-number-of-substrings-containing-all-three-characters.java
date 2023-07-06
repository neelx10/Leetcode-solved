class Solution {
    public int numberOfSubstrings(String s) {
        int[] count=new int[3];
        int i=0,j=0,ans=0;
        int n=s.length();
        while(j<n){
            count[s.charAt(j)-'a']++;
            while(count[0]>0 && count[1]>0 && count[2]>0){
                ans+=(n-j);
                count[s.charAt(i++)-'a']--;
            }
            j++;
        }
        return ans;
    }
}