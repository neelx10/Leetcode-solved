class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 0,windowSum = 0,i = 0,j=0;
        while(j < nums.length) {
            windowSum += nums[j];
            while ((j - i + 1) * nums[j] - windowSum > k) windowSum -= nums[i++];
            maxFreq = Math.max(maxFreq, j - i + 1);
            j++;
        }
        return maxFreq;
    }
}