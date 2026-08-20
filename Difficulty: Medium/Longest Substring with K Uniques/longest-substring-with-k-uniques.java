class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        
        int n = s.length();
        int low =0, res =-1;
        //HashMap<Character, Integer> freq = new hashMap<>();
        Map<Character, Integer> freq = new HashMap<>();
        
        for(int high =0;high<n ; high++){
            char c = s.charAt(high);
            
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
            
            while(freq.size() > k){
                char leftChar = s.charAt(low);
                
                int count = freq.get(leftChar);
                count = count - 1;
                freq.put(leftChar, count);
                
                if(freq.get(leftChar)==0)
                    freq.remove(leftChar);
                low++;
            }
            
            if(freq.size()==k)
                res = Math.max(res,high-low+1);
        }
        
        
        return res;
    }
}