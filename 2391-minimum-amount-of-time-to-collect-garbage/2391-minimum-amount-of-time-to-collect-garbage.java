class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;
        int res = 0;
        Set<Character> s = new HashSet<>();
        for (int i = len - 1; i >= 0 ; i--) {
            for (char ch : garbage[i].toCharArray()) {
                if (!s.contains(ch)) s.add(ch);
            }
            res += garbage[i].length();
            res += i > 0 ? s.size() * travel[i - 1] : 0;
        }
        return res;
    }
}