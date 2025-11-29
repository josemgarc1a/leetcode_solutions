class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while (i < j) {
            int currentHeight = Integer.min(height[i], height[j]);
            int currentWidth = j-i;
            int currentMaxArea = currentHeight * currentWidth;
            if (currentMaxArea > maxArea) {
                maxArea = currentMaxArea;
            }

            if (height[i] <= height[j]) {
                i++;
            } else { 
                j--;
            }
        }
        return maxArea;  
    }
}