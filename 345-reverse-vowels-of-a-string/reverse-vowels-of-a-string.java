class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;

        while (left < right) {
            if (!vowels.contains(chars[left])) {
                left++;
                continue;
            }

            if (!vowels.contains(chars[right])) {
                right--;
                continue;
            }

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }
}