class Solution {
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void perm(int pointer,List<List<Integer>> ans,int[] nums){
        if(pointer==nums.length){
            List<Integer> al = new ArrayList<Integer>();
            for(int i:nums) al.add(i);
            ans.add(al);
            return;
        }

        for(int i=pointer;i<nums.length;i++){
            swap(nums,i,pointer);
            perm(pointer+1,ans,nums);
            swap(nums,i,pointer);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        perm(0,ans,nums);
        return ans;
    }
}


