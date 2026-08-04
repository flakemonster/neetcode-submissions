class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        d = {}
        for i in s:
            d[i] = d.get(i, 0)+1
        for i in t:
            d[i] = d.get(i, 0)-1

        for k in d.keys():
            if d[k]!= 0:
                return False
        return True
