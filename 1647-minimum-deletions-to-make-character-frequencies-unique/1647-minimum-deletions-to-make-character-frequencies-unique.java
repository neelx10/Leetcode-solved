class Solution {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        Set<Integer> set=new HashSet<>();
        for(char c:s.toCharArray()) freq[c-'a']++;
        Arrays.sort(freq);
        int count=0;
        for(int i=25;i>=0;i--){
            if(freq[i]!=0){
                if(!set.contains(freq[i])) set.add(freq[i]);
                else{
                    while(set.contains(freq[i]) && freq[i]!=0){
                        count++;
                        freq[i]--;
                    }
                    if(freq[i]!=0) set.add(freq[i]);
                }
            }
            else break;
        }
        return count;
    }
}