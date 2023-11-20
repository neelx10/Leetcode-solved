class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        int gt = 0, mt = 0, pt = 0, d = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            time += s.length();
            if (i > 0) {
                d += travel[i - 1];
                if (s.contains("G")) {
                    time += d - gt;
                    gt = d;
                }
                if (s.contains("M")) {
                    time += d - mt;
                    mt = d;
                }
                if (s.contains("P")) {
                    time += d - pt;
                    pt = d;
                }
            }
        }
        return time;
    }
}