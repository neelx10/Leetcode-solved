class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = new char[26];
            for(char c:s.toCharArray()) arr[c-'a']++;
            String hash = String.valueOf(arr);
            if(map.containsKey(hash)) map.get(hash).add(s);
            else{
                map.put(hash,new ArrayList<String>());
                map.get(hash).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }   
}