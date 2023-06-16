class Solution {
    long mod=1000000007;
    public int solve(List<Long> nums,List<List<Long>> list){
        int n=nums.size();
        if(n<3) return 1;
        List<Long> left=new ArrayList<>();
        List<Long> right=new ArrayList<>();
        long root=nums.get(0);
        for(int i=1;i<n;i++){
            if(nums.get(i)<root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        Long x=solve(left,list)%mod;
        Long y=solve(right,list)%mod;
        Long z=(list.get(n-1).get(left.size()))%mod;
        return (int)(((x*y)%mod*z)%mod);
    }
    public int numOfWays(int[] nums) {
        //pascal triangle
        int n=nums.length;
        List<List<Long>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            List<Long> temp=new ArrayList<>(i+1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) temp.add(1L);
                else{
                    Long ans=(list.get(i-1).get(j)+list.get(i-1).get(j-1))%mod;
                    temp.add(ans);
                }
            }
            list.add(temp);
        }
        List<Long> arr=new ArrayList<>();
        for(int num:nums) arr.add((long)num);
        return (solve(arr,list)-1);
    }
}


