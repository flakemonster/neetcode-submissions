class Twitter {
    int timestamp;

    // userId -> set(following userid's)
    Map<Integer, Set<Integer>> followMap;

    // userId -> list(tweetids, time)
    Map<Integer, List<Pair<Integer, Integer>>> tweetMap;
    public Twitter() {
        timestamp = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer, Integer>> tweetsForUser =
            tweetMap.getOrDefault(userId, new ArrayList<>());

        tweetsForUser.add(new Pair<Integer, Integer>(tweetId, ++timestamp));
        tweetMap.put(userId, tweetsForUser);
        // System.out.println(
        //     "userId " + userId + " tweetId " + tweetId + " total tweets " + tweetsForUser.size());
    }

    public List<Integer> getNewsFeed(int userId) {
        //System.out.println("getNewsFeed " + userId);
        List<Integer> res = new ArrayList<>();

        // max heap i.e stores in descending order
        PriorityQueue<Pair<Integer, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // now add all pair values of the followers in the maxHeap
        Set<Integer> followingUsers = followMap.getOrDefault(userId, new HashSet<>());
        if (!followingUsers.contains(userId))
            followingUsers.add(userId);
        if (!followingUsers.isEmpty()) {
            //System.out.println("followingUsers isn't empty size " + followingUsers.size());
            for (int followingUserIds : followingUsers) {
                //System.out.println("followingUserId's " + followingUserIds);
                // get the tweets from followingUserId's
                List<Pair<Integer, Integer>> tweetsForUser = tweetMap.get(followingUserIds);
                // System.out.println("followingUserId's tweet map size "+tweetsForUser.size());
                //  add all tweets into the max heap
                if (tweetsForUser != null) {
                    for (Pair<Integer, Integer> tweet : tweetsForUser) {
                        maxHeap.add(tweet);
                    }
                }
            }
        }

        int count = 0;
        while (!maxHeap.isEmpty() && count != 10) {
            Pair<Integer, Integer> tweet = maxHeap.poll();
            count++;
            res.add(tweet.getKey());
        }
        //System.out.println("returning res size " + res.size());
        return res;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followingUsers = followMap.getOrDefault(followerId, new HashSet<>());
        // follow itself

        // follow others
        followingUsers.add(followeeId);
        followMap.put(followerId, followingUsers);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followingUsers = followMap.getOrDefault(followerId, new HashSet<>());
        followingUsers.remove(followeeId);
        
    }
}
