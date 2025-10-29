class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int s1 = value(s.charAt(i));

            if (i + 1 < s.length()) {
                int s2 = value(s.charAt(i + 1));

                if (s1 >= s2) {
                    result += s1;
                } else {
                    result += s2 - s1;
                    i++; // Пропускаем следующую цифру, так как мы её уже обработали
                }
            } else {
                result += s1;
            }
        }
        return result;
    }

    static int value(char r) {
        return switch (r) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
        }

        
    }


