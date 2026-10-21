class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: nums) {
            map.put(i, map.getOrDefault(i,0)+1);
        }

         List<Integer>[] buckets = new List[nums.length + 1];

         for(int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
         }
          for (int i : map.keySet()) {
            buckets[map.get(i)].add(i);     // index = frequency, value = number
        }
         int idx = 0;
         int[] result = new int[k];
         for(int i = nums.length; i > 0 && idx < k; i--) {
            for(int n: buckets[i]) {
                result[idx] = n;
                idx++;
                if(idx == k) return result;
            }
         }
         return result;
    }
}
