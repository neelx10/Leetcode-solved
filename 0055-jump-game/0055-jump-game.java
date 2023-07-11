class Solution {
    public boolean isPossible(int ind, int[] nums, Boolean[] memo) {
        if (ind == nums.length - 1) return true;
        if (ind >= nums.length) return false;
        if (memo[ind] != null) return memo[ind];
        for (int i = nums[ind]; i > 0; i--) {
            if (isPossible(ind + i, nums, memo)) {
                return memo[ind] = true;
            }
        }
        return memo[ind] = false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] memo = new Boolean[n];
        return isPossible(0, nums, memo);
    }
}
