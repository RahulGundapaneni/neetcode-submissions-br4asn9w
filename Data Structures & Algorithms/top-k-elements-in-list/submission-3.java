class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1:1, 2: 2 ,3:3

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i : map.keySet()) {
            pq.add(new int[]{i, map.get(i)});
        }
        int [] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
