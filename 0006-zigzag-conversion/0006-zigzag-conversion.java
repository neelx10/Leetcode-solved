class Solution {
    public String convert(String s, int r) {
        if(r == 1 || s.length() < r) return s;
        ArrayList<StringBuilder> al = new ArrayList<>();
        int k = 0;
        for(int i =0; i<r; i++) al.add(new StringBuilder());
        boolean down = false;
        for(char c: s.toCharArray()){
            al.get(k).append(c);
            if(k == 0 || k ==  r-1) down = !down;
            k += down ? 1 : -1;
        }
        StringBuilder st = new StringBuilder();
        for(StringBuilder str : al) st.append(str);
        return st.toString();
    }
}