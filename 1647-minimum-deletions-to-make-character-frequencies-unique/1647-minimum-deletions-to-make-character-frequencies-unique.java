class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            int temp=freq[i];
            while (temp != 0 && set.contains(temp)) {
                temp--;
                count++;
            }
            if (temp != 0) set.add(temp);
        }
        return count;
    }
}