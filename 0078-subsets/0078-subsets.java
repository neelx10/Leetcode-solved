class Solution {
    void solve(int idx,int[] arr,int sum,List<Integer> list,List<List<Integer>> ans){
        if(idx==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        solve(idx+1,arr,sum+arr[idx],list,ans);
        list.remove(list.size()-1);
        solve(idx+1,arr,sum,list,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        solve(0,nums,0,list,ans);
        return ans;
    }
}