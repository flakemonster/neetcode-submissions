class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i: nums) {
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }

        List<Integer>[] frequencyBucket = new List[nums.length+1];

        for (int key: countMap.keySet()) {
            int freq = countMap.get(key);
            if (frequencyBucket[freq] == null) {
                frequencyBucket[freq] = new ArrayList<>();
            }
            frequencyBucket[freq].add(key);
        }
        int[] res = new int[k];
        int counter = 0;
        for (int position=frequencyBucket.length-1; position>=0 
            && counter<k; position--) {
                if (frequencyBucket[position]!=null) {
                    for(Integer it: frequencyBucket[position]) {
                        res[counter++] = it;
                    }
                }
        }
        return res;
    }
}
