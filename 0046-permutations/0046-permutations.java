class Solution {
    public void solve(List<List<Integer>> ans,List<Integer> list,int[] nums,int[] visited){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                visited[i]=1;
                list.add(nums[i]);
                solve(ans,list,nums,visited);
                list.remove(list.size()-1);
                visited[i]=0;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] visited=new int[nums.length];
        solve(ans,new ArrayList<>(),nums,visited);
        return ans;
    }
}