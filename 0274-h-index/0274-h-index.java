class Solution {
    public int find(int[]nums, int mid){
        int count = 0;
        for(int ele : nums){
            if(ele >= mid) count++;
        }
        return count;
    }
    public int hIndex(int[] citations) {
        int low = 1;
        int high = citations.length;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(find(citations, mid) >= mid){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}