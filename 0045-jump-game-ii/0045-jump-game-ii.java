class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int currEnd = 0;
        int currFarthest = 0;
        for (int i = 0; i < n - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = currFarthest;
                if (currEnd >= n - 1) break;
            }
        }
        return jumps;
    }
}




