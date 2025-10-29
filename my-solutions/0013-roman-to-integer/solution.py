class Solution:
    def romanToInt(self, s):
        result = 0
        i = 0
        n = len(s)
        
        while i < n:
            s1 = self.value(s[i])
            
            if i + 1 < n:
                s2 = self.value(s[i + 1])
                if s1 >= s2:
                    result += s1
                else:
                    result += s2 - s1
                    i += 1
            else:
                result += s1
                
            i += 1
            
        return result
    
    def value(self, r):
        roman_values = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        return roman_values.get(r, -1)
