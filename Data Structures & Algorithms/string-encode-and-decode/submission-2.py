class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for word in strs:
            length = len(word)
            res+=str(length)+"#"+word
        return res

    def decode(self, s: str) -> List[str]:
        i = 0
        res = []
        while i<len(s):
            j=i
            while j<len(s) and s[j]!="#":
                j+=1
            length = int(s[i:j])
            res.append(s[j+1:j+1+length])
            i = j+1+length
        return res

