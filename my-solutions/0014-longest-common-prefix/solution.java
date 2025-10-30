class Solution {
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";

    int count = 0;
    boolean stop = false;

    // Проходим по всем буквам первого слова
    for (int i = 0; i < strs[0].length() && !stop; i++) {
        char currentChar = strs[0].charAt(i);

        // Проверяем эту букву во всех остальных словах
        for (int j = 1; j < strs.length; j++) {
            // Если слово короче или буква не совпадает
            if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                stop = true;
                break;
            }
        }

        // Если все слова имеют эту букву на этой позиции
        if (!stop) {
            count++;
        }
    }

    return strs[0].substring(0, count);
}
}   
