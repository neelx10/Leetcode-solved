class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int r = 0; r < routes.length; r++) {
            for (int stop : routes[r]) {
                if(!adjList.containsKey(stop)) adjList.put(stop,new ArrayList<>());
                adjList.get(stop).add(r);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<Integer>(routes.length);
        for (int route : adjList.get(source)) {
            q.add(route);
            vis.add(route);
        }
        
        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int route = q.remove();
                // Iterate over the stops in the current route.
                for (int stop: routes[route]) {
                    if (stop == target) return busCount;
                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adjList.get(stop)) {
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
};