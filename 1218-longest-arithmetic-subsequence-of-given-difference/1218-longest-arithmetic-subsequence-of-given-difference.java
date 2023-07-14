class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int maxLen=1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            int curr = map.getOrDefault(i - difference, 0) + 1;
            map.put(i, curr);
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }
}