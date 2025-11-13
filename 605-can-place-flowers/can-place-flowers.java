class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] copy = flowerbed.clone();
        if (n==0) return true;

        for (int i=0; i<copy.length; i++) {
            if ( copy[i]==0 && (i==0 || copy[i-1]==0) && (i==copy.length-1 || copy[i+1]==0) ) {
                copy[i] = 1;
                i++;
                n--;
            }
            if (n==0) return true;
        }
        return false;   
    }
}