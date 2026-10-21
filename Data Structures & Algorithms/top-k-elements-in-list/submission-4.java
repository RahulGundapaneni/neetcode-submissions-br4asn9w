class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<int[]> arr = new ArrayList<>();
        for(int i: map.keySet()) {
            int a[] = new int[]{map.get(i), i};
            arr.add(a);
        }
        arr.sort((a, b) -> b[0] - a[0]); 
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr.get(i)[1];           
        }
        return result;
    }
}
