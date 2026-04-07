class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> st = new Stack<>();
        int l = temperatures.length;
        int[] result = new int[l];
        for(int i = 0; i < l; i++) {
            int curr = temperatures[i]; 
            while( !st.isEmpty() && st.peek()[0] < curr) {  
                int outIndex = st.pop()[1];  
                result[outIndex] = i - outIndex;  
            }
            st.push(new int[]{curr, i});
        }
        return result;
    }
}
