class Twitter {
    Map<Integer, Set<Integer>> friends;
    int curr;
    PriorityQueue<int[]> timeline;

    Twitter() {
        friends = new HashMap<>();
        curr = 0;
        timeline = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    }

    public void postTweet(int userId, int tweetId) {
        timeline.offer(new int[]{curr++, tweetId, userId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> userTimeline = new PriorityQueue<>(timeline);

        int n = 0;
        while (!userTimeline.isEmpty() && n < 10) {
            int[] topTweet = userTimeline.poll();
            if (topTweet[2] == userId || (friends.containsKey(userId) && friends.get(userId).contains(topTweet[2]))) {
                ans.add(topTweet[1]);
                n++;
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        friends.putIfAbsent(followerId, new HashSet<>());
        friends.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (friends.containsKey(followerId)) {
            friends.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */