class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]){
                long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1];
                ans += numElements - 1;
                nums[i] /= (int)numElements;
            }
        }
        return ans;
    }
}