class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            while (freq[i] != 0 && set.contains(freq[i])) {
                freq[i]--;
                count++;
            }
            if (freq[i] != 0) set.add(freq[i]);
        }
        return count;
    }
}