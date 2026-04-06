class Twitter {

   private static int timeStamp = 0;
    
    // Internal class to track time and ID together
    private class Tweet {
        int id;
        int time;
        Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
        }
    }

    private Map<Integer, Set<Integer>> followerMap;
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new LinkedList<>());
        tweetMap.get(userId).add(0, new Tweet(tweetId)); // Add to front for faster access
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Min-Heap based on time: oldest at the top
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (followerMap.containsKey(userId)) {
            users.addAll(followerMap.get(userId));
        }

        for (int user : users) {
            List<Tweet> tweets = tweetMap.get(user);
            if (tweets == null) continue;
            
            for (Tweet t : tweets) {
                pq.offer(t);
                if (pq.size() > 10) pq.poll(); // Remove oldest to keep 10 newest
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().id); // Add to front to return newest first
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followerMap.putIfAbsent(followerId, new HashSet<>());
        followerMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerMap.containsKey(followerId) && followerId != followeeId) {
            followerMap.get(followerId).remove(followeeId);
        }
    }
}
