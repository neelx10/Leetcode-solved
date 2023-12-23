class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer,Integer>> set=new HashSet<>();
        int i=0,j=0;
        set.add(new Pair(0,0));
        for(char c:path.toCharArray()){
            if(c=='N') j++;
            else if(c=='S') j--;
            else if(c=='E') i++;
            else i--;
            
            Pair<Integer,Integer> temp=new Pair(i,j);
            if(set.contains(temp)) return true;
            set.add(temp);
        }
        return false;
    }
}