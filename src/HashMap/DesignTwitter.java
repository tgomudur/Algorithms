package HashMap;

/**
 * Created by tharun on 1/9/17.
 * Problem description: https://leetcode.com/problems/design-twitter/
 */

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class Tweet {
    int tweetId;
    int time;
    Tweet next;

    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        time = timestamp++;
        next = null;
    }
}

class User {
    int userId;
    HashSet<Integer> follows;
    Tweet tweetHead;

    public User(int userId) {
        this.userId = userId;
        this.follows = new HashSet<>();
        this.tweetHead = null;
        follows.add(userId);
    }

    public void post(Tweet newTweet) {
        // Add latest tweet to the front.
        newTweet.next = tweetHead;
        tweetHead = newTweet;
    }

    public void follow(int userId) {
        follows.add(userId);
    }

    public void unfollow(int userId){
        follows.remove(new Integer(userId));
    }
}

class Twitter {
    static int timestamp = 0;
    HashMap<Integer, User> usersMap;

    /** Initialize your data structure here. */
    public Twitter() {
        usersMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timestamp++);

        if (!usersMap.containsKey(userId)) usersMap.put(userId, new User(userId));
        usersMap.get(userId).post(newTweet);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feedList = new LinkedList<>();

        if (!usersMap.containsKey(userId)) return feedList;

        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(10, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t2.time - t1.time;
            }
        });

        for (int followerId : usersMap.get(userId).follows) {
            User user = usersMap.get(followerId);
            // System.out.println(usersMap.get(userId).follows);
            if (user.tweetHead != null)
                minHeap.add(user.tweetHead);
        }


        Tweet tmpTweet;
        while (!minHeap.isEmpty() && feedList.size() < 10) {
            tmpTweet = minHeap.poll();
            if (tmpTweet != null)
                feedList.add(tmpTweet.tweetId);

            if (tmpTweet.next != null) {
                minHeap.add(tmpTweet.next);
            }
        }

        return feedList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!usersMap.containsKey(followerId))
            usersMap.put(followerId, new User(followerId));

        if (!usersMap.containsKey(followeeId))
            usersMap.put(followeeId, new User(followeeId));

        usersMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (usersMap.containsKey(followerId) && followerId != followeeId)
            usersMap.get(followerId).unfollow(followeeId);
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
    @Test
    public void testTwitter() {
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        assertEquals(Arrays.asList(6, 5), twitter.getNewsFeed(1));

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));
    }
}
