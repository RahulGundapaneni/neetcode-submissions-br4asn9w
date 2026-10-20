class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String s: strs) {
            int[] count = new int[26];
            char[] c = s.toCharArray();
            for(char curr : c) {
                count[curr -'a']++;
            }
        String sorted = Arrays.toString(count);
        res.putIfAbsent(sorted, new ArrayList<>());

        res.get(sorted).add(s);
    }
    return new ArrayList<>(res.values());
    }
}
