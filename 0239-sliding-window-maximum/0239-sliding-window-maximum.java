class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[n-k+1];
        int j=0;
        //starting for the first k elements
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) dq.removeLast();
            dq.addLast(i);
        }

        for(int i=k;i<n;i++){
            ans[j++]=nums[dq.peek()];

            while(!dq.isEmpty() && dq.peek()<=i-k) dq.removeFirst();

            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) dq.removeLast();

            dq.addLast(i);
        }
        ans[j]=nums[dq.peek()];

        return ans;
    }
}