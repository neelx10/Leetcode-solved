class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int start = 0;
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;
        int longestSubstringLength = 0;

        for (int end = 0; end < s.length(); end ++) {
            frequencyMap[s.charAt(end) - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequencyMap[s.charAt(end) - 'A']);
            if (!(end + 1 - start - maxFrequency <= k)) frequencyMap[s.charAt(start++) - 'A']--;
            longestSubstringLength = end + 1 - start;
        }
        return longestSubstringLength;
    }
}
