/***
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 
```
Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

***/

class Solution {
    public boolean isHappy(int n) {
       // return method1(n);
       return method2(n);
    }
    
    // Method 1:  Maintaing the set of previously occured numbers
    public boolean method1(int n) {
      Set<Integer> set = new HashSet<>();
        int newNum = n;
        set.add(newNum);
        
        while(newNum != 1) {
            newNum = getSumOfSquare(newNum);
            System.out.println(newNum);
            
            if(set.contains(newNum)) {
                return false;
            } else {
                set.add(newNum);
            }
        }
        return true;
    }
    
    // Method 2:  Two Pointers
    public boolean method2(int n) {
      
        int slow = n, fast = n;
        
        do {
            slow = getSumOfSquare(slow);
            fast = getSumOfSquare(getSumOfSquare(fast));
            
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }
    
    public int getSumOfSquare(int num) {
        int result = 0;
        while (num > 0) {
            result += Math.pow(num % 10, 2);
            num = num / 10;
        }
        return result;
    }
}
