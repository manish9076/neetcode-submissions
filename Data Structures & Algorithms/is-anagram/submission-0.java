class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1: Length must be same
        if(s.length() != t.length()){
            return false;
        }
        // Step 2: Array for 26 lowercase English letters
        int[] count = new int[26];

        // Step 3: Count characters from s
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        // Step 4: Subtract characters from t
        for(char ch : t.toCharArray()){
            count[ch - 'a']--;
        }
        
        // Step 5: Check all counts
        for(int val : count){
            if(val!=0) {
            return false;
        }
        }
        return true;
    }
    
}
