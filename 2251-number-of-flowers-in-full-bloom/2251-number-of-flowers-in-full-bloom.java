class Solution {
    public int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < arr.get(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList();
        List<Integer> ends = new ArrayList();
        for (int[] flower: flowers) {
            starts.add(flower[0]);
            ends.add(flower[1] + 1);
        }
        Collections.sort(starts);
        Collections.sort(ends);
        int[] ans = new int[people.length];
        for (int index = 0; index < people.length; index++) {
            int person = people[index];
            ans[index] = binarySearch(starts, person) - binarySearch(ends, person);
        }
        return ans;
    }
}