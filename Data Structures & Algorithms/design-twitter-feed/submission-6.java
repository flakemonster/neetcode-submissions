class Twitter {
    class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            next = null;
        }
    }
    int timestamp;
    // userId --> set of followers
    Map<Integer, Set<Integer>> followMap;

    // userId --> latest tweet
    Map<Integer, Tweet> userTweetHead;
    public Twitter() {
        timestamp = 0;
        followMap = new HashMap<>();
        userTweetHead = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp++);
        Tweet previousUserTweet = userTweetHead.get(userId);
        tweet.next = previousUserTweet;
        userTweetHead.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        // Max-heap prioritizing the largest timestamp (most recent)
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        Tweet usersTweetHead = userTweetHead.get(userId);
        if(usersTweetHead != null)
            maxHeap.add(usersTweetHead);

        Set<Integer> following = followMap.get(userId);

        if (following != null) {
            for (int followingId : following) {
                Tweet tweetHead = userTweetHead.get(followingId);
                if(tweetHead != null)
                    maxHeap.add(tweetHead);
            }
        }

        while(!maxHeap.isEmpty() && res.size()<10) {
            Tweet cur = maxHeap.poll();

            res.add(cur.id);
            cur = cur.next;
            if(cur != null)
                maxHeap.add(cur);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId)
            followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId != followeeId)
            followMap.get(followerId).remove(followeeId);
    }
}
