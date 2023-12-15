class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> hasOutgoing = new HashSet();
        for (int i = 0; i < paths.size(); i++) hasOutgoing.add(paths.get(i).get(0));
        for (int i = 0; i < paths.size(); i++) {
            if (!hasOutgoing.contains(paths.get(i).get(1))) return paths.get(i).get(1);
        }
        return "";
    }
}