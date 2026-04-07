class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
        // create a HashMap with value, count
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        } 

        // Create another HashMap, which has count and values as list

        HashMap<Integer, List<Integer>> secMap = new HashMap<>();
        
        // for BucketSort we need to have Min and Max values to iterate over it
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : map.keySet()) {
            secMap.putIfAbsent(map.get(i), new ArrayList<>());
            secMap.get(map.get(i)).add(i);
            min = Math.min(min, map.get(i));
            max = Math.max(max, map.get(i));
        }

        int[] result = new int[k];
        int idx = 0;
        // Iterate over max to min && < k elements and save in an array
        for(int i = max; i >= min && idx < k; i--) {
            if(secMap.containsKey(i)) {
                for(int j: secMap.get(i)) {
                    result[idx] = j;
                    idx++;
                }
            }
        }
        

        return result;

    }
}
