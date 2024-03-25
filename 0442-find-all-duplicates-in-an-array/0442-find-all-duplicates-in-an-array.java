class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++) nums[nums[i]%(n+1) - 1]+=(n+1);
        for(int i=0;i<n;i++){
            if(nums[i]/(n+1) > 1) list.add(i+1);
            nums[i]=nums[i]%n;
        }
        return list;
    }
}