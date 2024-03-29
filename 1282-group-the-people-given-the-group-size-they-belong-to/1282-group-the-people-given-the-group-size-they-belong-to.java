class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            int temp=groupSizes[i];
            if(!map.containsKey(temp)) map.put(temp,new ArrayList<>());
            List<Integer> list=map.get(temp);
            list.add(i);
            if(list.size()==temp){
                ans.add(list);
                map.remove(temp);
            }
        }
        return ans;
    }
}