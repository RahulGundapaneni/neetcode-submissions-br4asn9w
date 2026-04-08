class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // cat and tac - anagram
        // HashMap<String, List<String>
        // 1st string sorted string 

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String t = new String(chars);
            if(map.containsKey(t)) {
                map.get(t).add(s);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(t, temp);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String re: map.keySet()) {
            result.add(map.get(re));
        }
        return result;
    }
}
