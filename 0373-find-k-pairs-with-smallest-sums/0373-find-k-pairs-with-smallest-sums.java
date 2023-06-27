class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        //sum as priority
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));

        for(int i=0;i<Math.min(nums1.length,k);i++) pq.offer(new int[]{i,0});

        while(k>0 && !pq.isEmpty()){
            int[] temp=pq.poll();
            res.add(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
            if(temp[1]<nums2.length-1) pq.offer(new int[]{temp[0],temp[1]+1});
            k--;
        }
        return res;
    }
}