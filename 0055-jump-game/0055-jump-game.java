class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0; 
        for(int idx = 0; idx < nums.length; idx++) {
            if(reach==nums.length-1) return true;
            if(reach < idx) return false;
            reach = Math.max(reach, idx + nums[idx]);
        }
        return true;
    }
}