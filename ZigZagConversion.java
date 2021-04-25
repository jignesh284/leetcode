class Solution {
    public String convert(String s, int numRows) {
        String[] strArr = new String[numRows];
        int r = 2*(numRows-1);
        if(numRows == 1) return s;
        String result = "";
        
        for(int i=0; i<s.length(); i=i+r) {
            for(int j=0; j<numRows; j++) {
               if(j % numRows == 0 || (j+1) % numRows == 0) {
                    if(strArr[j] == null) strArr[j] = "";
                    if(i+j < s.length())
                        strArr[j] += s.charAt(i+j);
                } else {
                    if(strArr[j] == null) strArr[j] = "";
                    if(i+j < s.length())
                        strArr[j] += s.charAt(i+j);
                    
                    if((i+r-j) < s.length()) 
                        strArr[j] += s.charAt(i+r-j);
                    
                }
            }
        }
        
        for(int i=0; i< strArr.length; i++){
            result += strArr[i];
        }
        return result;
   }
}
