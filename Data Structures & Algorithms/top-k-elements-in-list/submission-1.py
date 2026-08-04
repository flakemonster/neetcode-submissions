class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # count map num -> their count
        count = {}
        
        # freq map for each frequency map it to a list,
        # initialize to empty list
        # index is frequency, value is the list of numbers 
        # that occur the times as it's index
        freq = [[] for i in range(len(nums)+1)]
        for n in nums:
            count[n] = count.get(n,0)+1
        

        for n, c in count.items():
            freq[c].append(n)
        
        res = []

        for i in range(len(freq)-1, 0, -1):
            for n in freq[i]:
                res.append(n)
                if len(res)==k:
                    return res

