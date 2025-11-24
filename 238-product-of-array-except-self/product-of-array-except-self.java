class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arraySize = nums.length;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i=1; i<arraySize; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }


        int rightProduct = 1;
        for (int j=arraySize-1; j>=0; j--) {
            result[j] = result[j] * rightProduct;
            rightProduct *= nums[j];
        }
        return result;      
    }
}