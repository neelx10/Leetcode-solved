class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int i=0;
        List<int[]> res=new ArrayList<>();

        while(i<n && intervals[i][1]<newInterval[0]) res.add(intervals[i++]);

        int[] temp=newInterval;
        while(i<n && intervals[i][0]<=newInterval[1]){
            temp[0]=Math.min(temp[0],intervals[i][0]);
            temp[1]=Math.max(temp[1],intervals[i][1]);
            i++;
        }
        res.add(temp);

        while(i<n) res.add(intervals[i++]);
        return res.toArray(new int[res.size()][2]);
    }
}

