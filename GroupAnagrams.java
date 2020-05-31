/******

Given an array of strings, group anagrams together.

Example:
```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

Note:
All inputs will be in lowercase.
The order of your output does not matter.

******/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        
        //Creating a map of list so that its is accessible in O(1)
        for(int i=0; i< strs.length; i++) {
           String key = SortAString(strs[i]);
            if(!map.containsKey(key)) {
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            } else{
                list = map.get(key);
                list.add(strs[i]);
                map.put(key, list);
            }
        } 
        
        //Converting map to list of list to match output format
        
        /* 
          List<List<String>> result = new ArrayList<>();
          for(Map.Entry<String,List<String>> entry: map.entrySet()) {
              result.add(entry.getValue());
          }
          return result;
        */ 
         
        return new ArrayList<>(map.values());
    }
    
    public String SortString(String inputString) {
         // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 

        // sort tempArray 
        Arrays.sort(tempArray); 

        // return new sorted string 
        return new String(tempArray);
        
    }
}
