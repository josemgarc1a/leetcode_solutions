class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().orElse(0);

        List<Boolean> results = Arrays.stream(candies)
            .mapToObj(candy -> candy+extraCandies >= maxCandies)
            .collect(Collectors.toList());
        
        return results;
    } 
}