class Solution {
    public int compareVersion(String v1, String v2) {
        int i=0,j=0,len1=v1.length(),len2=v2.length();
        while(i<len1 || j<len2){
            int n1=0,n2=0;
            while(i<len1 && v1.charAt(i)!='.') n1=n1*10+(v1.charAt(i++)-'0');
            while(j<len2 && v2.charAt(j)!='.') n2=n2*10+(v2.charAt(j++)-'0');
            if(n1<n2) return -1;
            else if(n1>n2) return 1;
            i++;
            j++;
        }
        return 0;
    }
}