class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n=grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) list.add(grid[i][j]);
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(grid[i][j]);
            count += map.getOrDefault(list, 0);
        }
        return count;
    }
}