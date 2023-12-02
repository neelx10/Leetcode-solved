class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map=new int[26];
        for(char c:chars.toCharArray()) map[c-'a']++;
        int ans=0;
        for(String word:words){
            int[] temp=map.clone();
            boolean flag=false;
            for(char c:word.toCharArray()){
                if(temp[c-'a']>0) temp[c-'a']--;
                else{
                    flag=true;
                    break;
                }
            }
            if(!flag) ans+=word.length();
        }
        return ans;
    }
}