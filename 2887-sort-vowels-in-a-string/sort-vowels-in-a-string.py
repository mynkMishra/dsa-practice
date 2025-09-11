class Solution(object):
    def sortVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        VOW = ['a','e','i','o','u','A','E','I','O','U']
        chars = list(s)
        N = len(chars)

        vow = []
        cons = []
        hMap = {}

        for idx in range(0, N):
            if chars[idx] in VOW:
                vow.append(chars[idx])
            else:
                cons.append(chars[idx])
                hMap[idx] = chars[idx]

        vow.sort()

        l = 0;
        r = 0;
        ans = ""

        for idx in range(0, N):
            if idx in hMap:
                ans += cons[r]
                r+=1
            else:
                ans += vow[l]
                l+=1
        
        return ans


        