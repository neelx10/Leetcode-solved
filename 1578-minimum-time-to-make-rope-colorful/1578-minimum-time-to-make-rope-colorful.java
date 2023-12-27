class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0,j=1,count=0;
        while(j<colors.length()){
            if(colors.charAt(i)==colors.charAt(j)){
                if(neededTime[i]>=neededTime[j]) count+=neededTime[j];
                else{
                    count+=neededTime[i];
                    i=j;
                }
            }
            else i=j;
            j++;
        }
        return count;
    }
}