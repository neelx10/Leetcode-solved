class Solution {
    private boolean valid(int[] nums, int p, int mid) {
        int i = 0, count = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                count++;
                i++;
            }
            i++;
            if(count==p) return true;
        }
        return false;
    }
    public int minimizeMax(int[] nums, int p) {
        if(p==0) return 0;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (valid(nums, p, mid)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}