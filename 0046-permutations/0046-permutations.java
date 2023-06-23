class Solution {
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void solve(int idx,List<List<Integer>> ans,int[] nums){
        if(idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i:nums) list.add(i);
            ans.add(list);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(idx,i,nums);
            solve(idx+1,ans,nums);
            swap(idx,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,ans,nums);
        return ans;
    }
}