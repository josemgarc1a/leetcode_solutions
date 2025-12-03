class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (k<=0 || nums.length<k) {
            throw new IllegalArgumentException();
        }

        int windowSum = 0;
        for (int i=0; i<k; i++) {
            windowSum += nums[i];
        }

        int maxSum=windowSum;

        for (int i=k; i<nums.length; i++) {
            windowSum += nums[i];
            windowSum -= nums[i-k];
            if (windowSum>maxSum) maxSum=windowSum;
        }

        return maxSum/(double)k;  
    }
}