class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";

        Map<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);

        int i=0,j=0,start_i=0,countReq=t.length(),minWindowSize=(int)1e9;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) countReq--;
                map.put(ch,map.get(ch)-1);
            }
            while(countReq==0){
                int currWindowSize=j-i+1;
                if(minWindowSize>currWindowSize){
                    minWindowSize=currWindowSize;
                    start_i=i;
                }
                char c=s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                    if(map.get(c)>0) countReq++;
                }
                i++;
            }
            j++;
        }
        return minWindowSize==(int)1e9 ? "":s.substring(start_i,start_i+minWindowSize);
    }
}