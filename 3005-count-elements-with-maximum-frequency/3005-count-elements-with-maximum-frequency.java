public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0,totalFrequencies = 0;
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
            int frequency = frequencies.get(num);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                totalFrequencies = frequency;
            } 
            else if (frequency == maxFrequency) totalFrequencies += frequency;
        }
        return totalFrequencies;
    }
}