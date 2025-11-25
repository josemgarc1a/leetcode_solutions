class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1) return 1;
        
        int writeIndex = 0;  // Position to write compressed result
        int i = 0;           // Position to read from
        
        while (i < n) {
            char currentChar = chars[i];
            int count = 0;
            
            // Count consecutive same characters
            while (i < n && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            // Write the character
            chars[writeIndex++] = currentChar;
            
            // Write the count if > 1 (split multi-digit numbers into chars)
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }
        return writeIndex;       
    }
}