class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // create a HashMap with value, count
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        // initialize a Min Heap
        PriorityQueue<Integer> pq =new PriorityQueue<>((a,b) -> map.get(a) - map.get(b) );
        // gothrough HashMap and remove values less than count k
        for(int i: map.keySet()) {
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }
        int[] result = new int[k];
        int idx = 0;
        while(!pq.isEmpty()) {
            result[idx] = pq.poll();
            idx++;
        }
        return result;
    }
}
