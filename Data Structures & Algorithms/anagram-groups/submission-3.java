class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            String key2 = Arrays.toString(count);
            if (!map.containsKey(key2)) {
                map.put(key2, new ArrayList<>());
            }
            map.get(key2).add(s);
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;

    }
}
