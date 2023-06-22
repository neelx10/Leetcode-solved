class Solution {
    public void solve(int idx,int sum,List<List<Integer>> ans,List<Integer> list,int[] nums,int k,int target){
        if(list.size()==k){
            if(sum==target) ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(sum>target) return;
            list.add(nums[i]);
            solve(i+1,sum+nums[i],ans,list,nums,k,target);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,0,ans,new ArrayList<Integer>(),nums,k,n);
        return ans;
    }
}