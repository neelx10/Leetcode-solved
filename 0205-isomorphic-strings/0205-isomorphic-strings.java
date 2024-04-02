class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1=new HashMap<>();
        Set<Character> map2=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map1.containsKey(c1)){
                if(map1.get(c1)!=c2) return false;
            }
            else{
                if(map2.contains(c2)) return false;
                else{
                    map1.put(c1,c2);
                    map2.add(c2);
                }
            }
        }
        return true;
    }
}