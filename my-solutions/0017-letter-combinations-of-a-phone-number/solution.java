class Solution {
    private String[] mapping = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
        };
    public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.length() == 0) return result;
            backtrack(result, new StringBuilder(), digits, 0);
            return result;
        }
        void backtrack(List<String> result, StringBuilder current, String digits, int index) {
            if (index == digits.length()) {
                result.add(current.toString());
                return;
            }
            String letter = mapping[digits.charAt(index) - '0'];

            for (char c : letter.toCharArray()) {
                current.append(c);
                backtrack(result, current, digits, index + 1);
                current.deleteCharAt(current.length() - 1);
            }
        }
}
