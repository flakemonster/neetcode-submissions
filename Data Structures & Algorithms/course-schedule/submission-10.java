class Solution {

    // do a dfs traversal from one of the courses
    // dfs A -> B 
    // add A to visited
    // dfs(B)
    // check if B in visited
    // if so, it's a cycle, return 
    // if not, move to the next edge from B
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visited;
        HashMap<Integer, List<Integer>> prereqMap = new HashMap<>();

        // create a map of directed edges
        for(int i=0; i<prerequisites.length; i++) {

            List<Integer> prereqList = prereqMap.getOrDefault(prerequisites[i][0], new ArrayList<Integer>());
            prereqList.add(prerequisites[i][1]);
            prereqMap.put(prerequisites[i][0], prereqList);
        }

        for(int course: prereqMap.keySet()) {
            visited = new HashSet<>();
            if(isDfsCycle(prereqMap, course, visited))
                return false;
        }
        return true;
    }

    public boolean isDfsCycle(Map<Integer, List<Integer>> prereqMap, int currCourse, Set<Integer> visited) {
        
        if(visited.contains(currCourse))
            return true;
        
        if(!prereqMap.containsKey(currCourse))
            return false;

        visited.add(currCourse);

        for(int prereqCourse: prereqMap.get(currCourse)) {
            if(isDfsCycle(prereqMap, prereqCourse, visited)) {
                return true;
            }
        }
        visited.remove(currCourse);
        prereqMap.put(currCourse, new ArrayList<Integer>());
        return false;
    }
}
