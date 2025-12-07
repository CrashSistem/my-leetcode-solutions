class Solution {
    public int countOdds(int low, int high) {
        int totalNums = high - low + 1;
        if (low % 2 != 0){
            return (totalNums + 1) / 2;
        }
        return totalNums / 2;
        }
    }
