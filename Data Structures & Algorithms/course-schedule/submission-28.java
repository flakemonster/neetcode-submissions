class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        List<Integer> preList;
        Set<Integer> visited = new HashSet<>(); // Tracks current DFS path (cycle detection)
        Set<Integer> completed =
            new HashSet<>(); // Tracks courses already proven safe (memoization)

        // populate preMap: course -> prereq
        for (int i = 0; i < prerequisites.length; i++) {
            preList = preMap.getOrDefault(prerequisites[i][0], new ArrayList<>());
            preList.add(prerequisites[i][1]);
            preMap.put(prerequisites[i][0], preList);
        }

        for (int course : preMap.keySet()) {
            if (!dfsCanFinish(course, visited, completed, preMap))
                return false;
        }
        return true;
    }

    public boolean dfsCanFinish(
        int course, Set<Integer> visited, Set<Integer> completed, Map<Integer, List<Integer>> preMap) {
        //  terminal condition
        if(completed.contains(course))
            return true;

        //  if course is visited then return false
        if (visited.contains(course))
            return false;
        if (!preMap.containsKey(course)) {
            completed.add(course);
            return true;
        }

        visited.add(course);
        for (int c : preMap.get(course)) {
            if (!dfsCanFinish(c, visited, completed, preMap))
                return false;
        }
        visited.remove(visited.size() - 1);
        completed.add(course); 
        return true;
    }
}
