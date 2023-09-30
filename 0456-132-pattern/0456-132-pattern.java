class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        Stack<Integer> dq = new Stack<>();
        int maxThirdElement = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int temp = nums[i];
            if (temp < maxThirdElement) return true;  
            while (!dq.isEmpty() && dq.peek() < temp) maxThirdElement = dq.pop();
            dq.push(temp);
        }
        return false; 
    }
}