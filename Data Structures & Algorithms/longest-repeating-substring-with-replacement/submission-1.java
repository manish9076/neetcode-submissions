class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxFreq = 0; 
        int left = 0;

        Map<Character, Integer> map = new HashMap();
        
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            int replacements = (right - left + 1) - maxFreq;

            if(replacements > k) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
