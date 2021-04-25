/* 
Simple O(N2) solution with expand from center approach
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0;
        int len = 0;
        
        for(int i=0; i<s.length(); i++){
            int len1 = checkLongestPalindrome(s, i, i);
            int len2 = checkLongestPalindrome(s, i, i+1);
            
            if(len < Math.max(len1, len2)) {
                len =  Math.max(len1, len2);
                start = i - (len-1)/2;
            }
          
        }
        return s.substring(start, start+len);
    }
    
    private int checkLongestPalindrome(String s, int l, int r) {
        if(s == null || l > r) return 0;
        
        while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        return (r - l - 1);
    }
}

/* 
Dynamic Programming approch
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s == "") return "";
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLen = 1;
        int start = 0;
        
        // Initialising all the substring of length 1 
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
        }
        
        // Initialising all the substring of length 2 
        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1; 
                if(maxLen < 2) {
                    maxLen = 2;
                    start = i;
                }
            }
        }
        
        for(int len=3; len <=n; len++) {
            // starting index is i
            for(int i =0; i < n - len + 1; i++) {
                // end of the substring is j
                int j = i + (len-1); 
                if(dp[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                    if(maxLen < len) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
}
