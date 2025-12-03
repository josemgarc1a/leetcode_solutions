class Solution {
    public int maxVowels(String s, int k) {
        List<Character> VOWELS = List.of('a','e','i','o','u');
        if(s.isBlank() || k<=0 || k>s.length()) {
            throw new IllegalArgumentException();
        }

        int windowCount = 0;
        for (int i=0; i<k; i++){
            if(VOWELS.indexOf(s.charAt(i))>=0){
                windowCount++;
            }
        }
        
        int maxCount = windowCount;
        for (int i=k; i<s.length(); i++){
            //Character Leaving the Window
            if (VOWELS.indexOf(s.charAt(i-k))>=0) {windowCount--;}
            //Character Entering the Window
            if (VOWELS.indexOf(s.charAt(i))>=0) {windowCount++;}
            //Compare Max Value
            if (windowCount>maxCount) {maxCount=windowCount;}
        }

        return maxCount;
    }
}