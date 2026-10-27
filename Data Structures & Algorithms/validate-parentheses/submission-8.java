class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();

        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(map.containsKey(curr)) {
                st.add(curr);
            }
            else {
                if (st.isEmpty()) return false;
                if (map.get(st.pop()) != curr) return false;
            }
        }
        return st.isEmpty();
    }
}
