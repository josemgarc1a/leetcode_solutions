class Solution {
    public String gcdOfStrings(String str, String pattern) {
        if (str == null || pattern == null || str.isEmpty() || pattern.isEmpty()) {
            return "";
        }

        int strLength = str.length();
        int patternLength = pattern.length();
        
        // Find the greatest common divisor of the two lengths
        int gcd = gcd(strLength, patternLength);
        
        // Try all divisors of the GCD, starting from largest
        for (int len = gcd; len > 0; len--) {
            if (strLength % len == 0 && patternLength % len == 0) {
                // Get candidate from the shorter string to avoid index issues
                String candidate = (strLength <= patternLength) 
                    ? str.substring(0, len) 
                    : pattern.substring(0, len);
                
                // Check if both strings start with this candidate
                if (str.startsWith(candidate) && pattern.startsWith(candidate)) {
                    // Check if both strings are composed entirely of this candidate
                    if (isComposedOf(str, candidate, len) && 
                        isComposedOf(pattern, candidate, len)) {
                        return candidate;
                    }
                }
            }
        }
        
        return "";
    }

    // Euclidean algorithm for GCD
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Check if string is composed entirely of the pattern
    private boolean isComposedOf(String str, String pattern, int patternLength) {
        int strLength = str.length();
        if (strLength % patternLength != 0) {
            return false;
        }
        
        int repetitions = strLength / patternLength;
        for (int rep = 0; rep < repetitions; rep++) {
            int start = rep * patternLength;
            for (int i = 0; i < patternLength; i++) {
                if (str.charAt(start + i) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String getDivider(String str, String pattern, int strLength, int patternLength) {
        String divider = "";
        for (int i=str.indexOf(pattern); i<strLength; i+=patternLength) {
            if(str.substring(i, i+patternLength).equals(pattern)) {
                divider = pattern;
            } else {
                divider = "";
                break;
            }
        }
        return divider;
    }
}