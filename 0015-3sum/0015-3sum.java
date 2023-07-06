class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            while(j<k){
                int temp=nums[i]+nums[j]+nums[k];
                if(temp==0) res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(temp>0) k--;
                else j++;
            }
        }
        return new ArrayList(res);
    }
}