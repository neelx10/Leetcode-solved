class Solution {
    public boolean hasDuplicate(String s1,String s2){
        int[] arr=new int[26];
        for(char ch:s1.toCharArray()){
            if(arr[ch-'a']>0) return true;
            arr[ch-'a']++;
        }
        for(char ch:s2.toCharArray()){
            if(arr[ch-'a']>0) return true;
        }
        return false;
    }

    public int solve(int i,String temp,List<String> arr,int n,Map<String,Integer> map){
        if(i==n) return temp.length();
        if(map.containsKey(temp)) return map.get(temp);

        int include=0,exclude=0;
        if(hasDuplicate(arr.get(i),temp)){
            exclude=solve(i+1,temp,arr,n,map);
        }
        else{
            exclude=solve(i+1,temp,arr,n,map);
            include=solve(i+1,temp+arr.get(i),arr,n,map);
        }
        int res=Math.max(include,exclude);
        map.put(temp,res);
        return res;
    }
    
    public int maxLength(List<String> arr) {
        int n=arr.size();
        String temp="";
        Map<String,Integer> map=new HashMap<>();
        return solve(0,temp,arr,n,map);
    }
}