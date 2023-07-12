class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        if(nums.length % k!=0) return false;
        Arrays.sort(nums);
        Map<Integer,Integer> map=new LinkedHashMap<>();
        //hashmap doesnt guarantee the insertion order
        //use linkedhashmap so that insertion order remains intact
        for(int i:nums) map.put(i,map.getOrDefault(i,0)+1);

        while(map.size()>0){
            int temp = map.keySet().iterator().next();
            for(int i=temp;i<temp+k;i++){
                if(!map.containsKey(i)) return false;
                if(map.get(i)==1) map.remove(i);
                else map.put(i,map.get(i)-1);
            }
        }
        return true;
    }
}