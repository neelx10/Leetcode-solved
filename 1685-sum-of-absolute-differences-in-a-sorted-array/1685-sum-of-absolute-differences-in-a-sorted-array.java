class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int leftSum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int leftTotal = i * nums[i] - leftSum;
            int rightTotal = (totalSum - leftSum - nums[i]) - (n-1-i) * nums[i];
            ans[i] = leftTotal + rightTotal;
            leftSum += nums[i];
        }
        return ans;
    }
}