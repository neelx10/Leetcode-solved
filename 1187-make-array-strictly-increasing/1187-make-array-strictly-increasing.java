class Solution {
    
    public int upper_bound(int[] arr,int tar){
        int res=-1;
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(tar<arr[mid]){
                res=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return res;
    }
    
    public int solve(int idx,int[] arr1,int[] arr2,int prev,Map<Integer,Map<Integer,Integer>> map){
        //base case
        if(idx==arr1.length) return 0;
        if(map.containsKey(idx) && map.get(idx).containsKey(prev)) return map.get(idx).get(prev);
        //case1
        int res_1=(int)(1e9+1);
        if(arr1[idx]>prev) res_1=solve(idx+1,arr1,arr2,arr1[idx],map);
        //case2
        int res_2=(int)(1e9+1);
        int upperBound=upper_bound(arr2,prev);
        if(upperBound!=-1) res_2=1+solve(idx+1,arr1,arr2,arr2[upperBound],map);
        //to return
        map.putIfAbsent(idx,new HashMap<>());
        map.get(idx).put(prev,Math.min(res_1,res_2));
        return map.get(idx).get(prev);
    }
    
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer,Map<Integer,Integer>> map=new HashMap<>();
        Arrays.sort(arr2);
        int ans=solve(0,arr1,arr2,(int)-1e9,map);
        return (ans==(int)(1e9+1))?-1:ans;
    }
}