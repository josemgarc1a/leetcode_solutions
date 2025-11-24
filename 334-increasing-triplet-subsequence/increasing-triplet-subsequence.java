class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int a : nums) {
            if (a <= first) {
                first = a;
            } else if (a <= second) {
                second = a;
            } else {
                return true;
            }
        }

        return false;
    }
}