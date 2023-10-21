class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        
        heap.add(new int[] {nums[0], 0});
        int ans = nums[0];
        
        for (int j = 1; j < nums.length; j++) {
            while (j - heap.peek()[1] > k) heap.remove();
            int curr = Math.max(0, heap.peek()[0]) + nums[j];
            ans = Math.max(ans, curr);
            heap.add(new int[] {curr, j});
        }
        
        return ans;
    }
}

