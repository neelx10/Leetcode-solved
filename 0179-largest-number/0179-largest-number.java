class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String num1, String num2) {
        return (num1 + num2).compareTo(num2 + num1);
    }
}
    

class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        boolean zeros=true;
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
            if(nums[i]!=0) zeros=false;
        }
        
        if(zeros) return "0";

        // Sorting the array based on the custom comparator
        Arrays.sort(strNums, new CustomComparator());
        
        StringBuilder sb=new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
            sb.append(strNums[i]);
        }
        return sb.toString();
    }
}