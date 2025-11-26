class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int i = 0;
        int n = nums.length-1;
        while (i <= n) {
            if (nums[i] == 0) {
                for(int j = i; j < n; j++) {
                    nums[j] = nums[j+1];
                }
                nums[n] = 0;
                n--;
            } else {
                i++;
            }
        }        
    }
}