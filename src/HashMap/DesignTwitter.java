package HashMap;

/**
 * Created by tharun on 1/9/17.
 */
import java.util.*;
class Twitter {
    HashMap<Integer, HashSet<Integer>> userTweetsMap;
    HashMap<Integer, HashSet<Integer>> followersMap;
    HashMap<Integer, ArrayList<Integer>> newsFeedMap;

    /** Initialize your data structure here. */
    public Twitter() {
        userTweetsMap = new HashMap<>();
        followersMap = new HashMap<>();
        newsFeedMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // Add tweet to user tweets map
        if (!userTweetsMap.containsKey(userId)) userTweetsMap.put(userId, new HashSet<Integer>());
        userTweetsMap.get(userId).add(tweetId);

        // Add tweetId to front of news feed of userId
        if (!newsFeedMap.containsKey(userId)) newsFeedMap.put(userId, new ArrayList<Integer>());
        newsFeedMap.get(userId).add(0, tweetId);

        // Add tweetId to front of all userId's followers
        if (!followersMap.containsKey(userId)) followersMap.put(userId, new HashSet<Integer>());
        else {
            for (int followerId : followersMap.get(userId)) {
                if (!newsFeedMap.containsKey(followerId)) newsFeedMap.put(followerId, new ArrayList<Integer>());
                // Remove the last tweet is size == 10, before adding new tweet to news feed.
                if (newsFeedMap.get(followerId).size() == 10) newsFeedMap.get(followerId).remove(newsFeedMap.get(followerId).size() - 1);
                newsFeedMap.get(followerId).add(0, tweetId);
            }
        }
        System.out.println(followersMap);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return newsFeedMap.get(userId);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followersMap.containsKey(followeeId)) followersMap.put(followeeId, new HashSet<Integer>());
        followersMap.get(followeeId).add(followerId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followeeId)){
            followersMap.get(followeeId).remove(followerId);

            if (newsFeedMap.containsKey(followerId)) {
                ArrayList<Integer> currentUserFeed = new ArrayList<>(newsFeedMap.get(followerId));
                for (int tweetId : currentUserFeed) {
                    if (userTweetsMap.containsKey(followeeId) && userTweetsMap.get(followeeId).contains(tweetId))
                        newsFeedMap.get(followerId).remove(new Integer(tweetId));
                }
            }

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

public class DesignTwitter {
    public static void main (String[] args) {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 1);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        System.out.println(twitter.getNewsFeed(1));

        // User 1 follows user 2.
        twitter.follow(2, 1);

        System.out.println(twitter.getNewsFeed(2));

        // User 2 posts a new tweet (id = 6).
//        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//        System.out.println(twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(2, 1);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(2));
    }
}
