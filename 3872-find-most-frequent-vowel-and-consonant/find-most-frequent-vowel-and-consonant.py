class Solution:
    def maxFreqSum(self, s: str) -> int:
        vowels = ['a','e','i','o','u']
        vowMap = {}
        consMap = {}
        vowF = 0
        conF = 0

        chars = list(s)

        for ch in chars:
            if ch in vowels:
                vowMap[ch] =  1 if vowMap.get(ch) is None else vowMap[ch] + 1
                vowF = max(vowF, vowMap.get(ch))
            else:
                consMap[ch] =  1 if consMap.get(ch) is None else consMap[ch] + 1
                conF = max(conF, consMap.get(ch))
        
        return vowF + conF
