class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String[] strNums = new String[n];
        boolean zeros=true;
        for (int i = 0; i < n; i++) {
            strNums[i] = String.valueOf(nums[i]);
            if(nums[i]!=0) zeros=false;
        }
        if(zeros) return "0";
        
        Arrays.sort(strNums, (a,b)->(a + b).compareTo(b + a));
        
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=0;i--) sb.append(strNums[i]);
        return sb.toString();
    }
}