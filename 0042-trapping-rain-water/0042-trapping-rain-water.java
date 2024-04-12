class Solution {
    public int trap(int[] height) {
        int left = 0; // left pointer
        int right = height.length-1; // right pointer
        
        int leftMax = height[left];
        int rightMax = height[right];
        
        int totalTrappedWater = 0;
        while(left < right) {
            
            // check which pointer value is minimum
            if(height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalTrappedWater += leftMax - height[left];
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalTrappedWater += rightMax - height[right];
            }
        }
        return totalTrappedWater;
    }
}