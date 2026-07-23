class Solution {
    public String removeDuplicateLetters(String s) {
        // 1. Считаем количество вхождений каждого символа
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // 2. Массив для отслеживания символов, которые уже в стеке
        boolean[] inStack = new boolean[26];

        // 3. Стек на основе массива char
        char[] stack = new char[26];
        int top = -1; // Указатель на вершину стека

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            // Уменьшаем счетчик оставшихся символов в строке
            count[idx]--;

            // Если символ уже использован в ответе, пропускаем
            if (inStack[idx]) {
                continue;
            }

            // Пока стек не пуст, верхушка стека больше текущего символа 
            // И верхушка стека еще встретится дальше по строке:
            while (top >= 0 && stack[top] > c && count[stack[top] - 'a'] > 0) {
                inStack[stack[top] - 'a'] = false; // Помечаем как неиспользованный
                top--; // Выталкиваем из стека
            }

            // Добавляем текущий символ в стек
            stack[++top] = c;
            inStack[idx] = true;
        }

        // Собираем итоговую строку из стека
        return new String(stack, 0, top + 1);
    }
}
