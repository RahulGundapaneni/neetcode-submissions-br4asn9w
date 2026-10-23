class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right) {
            char leftChar = s.charAt(left); 
            char rightChar = s.charAt(right);

            while (left < right && !Character.isLetterOrDigit(leftChar)) {
                left++;
                leftChar = s.charAt(left); 
            }
            while (left < right && !Character.isLetterOrDigit(rightChar)) { 
                right--;
                rightChar = s.charAt(right); 
            }
            if (Character.isDigit(leftChar) && Character.isDigit(rightChar))  
            {
                if(leftChar != rightChar) {
                    return false;
                }
            } 

            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {   
                return false;
            } 
            left++;
            right--;
        }

        return true;
    }
}
