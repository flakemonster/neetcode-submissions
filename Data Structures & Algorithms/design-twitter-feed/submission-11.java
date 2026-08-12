class Twitter {
    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        public Tweet(int id, int timestamp) {
            tweetId = id;
            time = timestamp;
        }
    }

    int timestamp;
    //userId -> set<followers>
    Map<Integer, Set<Integer>> followMap;

    // userId -> tweetHead linked list
    Map<Integer, Tweet> tweetHeadMap;

    public Twitter() {
        timestamp = 0;
        followMap = new HashMap<>();
        tweetHeadMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp++);
        Tweet head = tweetHeadMap.get(userId);
        tweet.next = head;
        tweetHeadMap.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        // max Heap
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        // add user's own tweethead to maxHeap
        Tweet userHead = tweetHeadMap.get(userId);
        if(userHead != null) {
            //System.out.println("adding user to head "+userId);
            maxHeap.add(userHead);
        }
        
        if(followMap.get(userId) != null) {
            for(int followeeId: followMap.get(userId)) {
                //System.out.println("followeeId "+followeeId);
                Tweet tweetHead = tweetHeadMap.get(followeeId);
                if(tweetHead != null) {
                    //System.out.println("adding tweetId "+tweetHead.tweetId+" to heap");
                    maxHeap.add(tweetHead);
                    //tweetHead = tweetHead.next;
                }
            }
        }
        //System.out.println(" size of maxHeap "+maxHeap.size());

        while(!maxHeap.isEmpty() && res.size()<10) {
            Tweet tweetToAdd = maxHeap.poll();
            int tweetIdToAdd = tweetToAdd.tweetId;
            //System.out.println("tweetToAdd "+tweetIdToAdd);
            if(tweetToAdd.next != null) {
                //System.out.println("adding "+tweetToAdd.next.tweetId+" to heap");
                maxHeap.add(tweetToAdd.next);
            }
            res.add(tweetIdToAdd);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId) {
            followMap.computeIfAbsent(followerId, k -> new HashSet<Integer>()).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
