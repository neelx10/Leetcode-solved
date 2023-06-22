class Solution {
    public void fun(int i,int target,int[] arr,List<List<Integer>> ans,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i==arr.length){
            if(target==0) ans.add(new ArrayList<>(list));
            return;
        }
        if(arr[i]<=target){
            list.add(arr[i]);
            fun(i,target-arr[i],arr,ans,list);
            list.remove(list.size()-1);
        }
        fun(i+1,target,arr,ans,list);
    }
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,target,arr,ans,new ArrayList<>());
        return ans;
    }
}