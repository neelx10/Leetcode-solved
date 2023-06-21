class Pair{
    int first;
    String second;
    Pair(int first,String second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(1,beginWord));
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++) set.add(wordList.get(i));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int count=temp.first;
            String str=temp.second;
            if(str.equals(endWord)) return count;
            for(int i=0;i<str.length();i++){
                for(char c='a';c<='z';c++){
                    char[] ch=str.toCharArray();
                    ch[i]=c;
                    String s=new String(ch);
                    if(set.contains(s)){
                        q.offer(new Pair(count+1,s));
                        set.remove(s);
                    }
                }
            }
        }
        return 0;
    }
}




