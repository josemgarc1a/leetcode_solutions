class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int kidCandies : candies) {
            maxCandies=Math.max(kidCandies, maxCandies);
        }

        List<Boolean> results = new ArrayList<>();
        for (int kidCandies : candies) {
            results.add(kidCandies+extraCandies >= maxCandies);
        }
        return results;
    }
}