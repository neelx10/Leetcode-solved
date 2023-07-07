class Solution {
    private Boolean canMakeValidSubstring(String s,int substringLength,int k){
        // take a window of length `substringLength` on the given
        // string, and move it from left to right. If this window
        // satisfies the condition of a valid string, then we return
        // true
        int[] freqMap = new int[26];
        int maxFrequency = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end += 1) {
            freqMap[s.charAt(end) - 'A'] ++;
            if (end + 1 - start > substringLength) freqMap[s.charAt(start++) - 'A'] --;
            maxFrequency = Math.max(maxFrequency, freqMap[s.charAt(end) - 'A']);
            if (substringLength - maxFrequency <= k) return true;
        }
        return false;
    }
    
    public int maxConsecutiveAnswers(String s, int k) {
        // binary search over the length of substring
        // lo contains the valid value, and hi contains the
        // invalid value
        int lo = 1;
        int hi = s.length() + 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canMakeValidSubstring(s, mid, k)) lo = mid;
            else hi = mid;
        }
        return lo;
    }
}

