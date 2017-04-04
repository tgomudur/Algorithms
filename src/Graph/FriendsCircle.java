package Graph;

/**
 * Created by tharun on 4/2/17.
 * <p>There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature. For example, if A is a direct friend of B,
 * and B is a direct friend of C, then A is an indirect friend of C. And we defined a f
 * A friend circle is a group of students who are direct or indirect friends.</p>
 *
 * <p>Given a N*N matrix M representing the friend relationship between students in the class.
 * If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.</p>
 *
 * <a href = https://leetcode.com/contest/leetcode-weekly-contest-26/problems/friend-circles/>More info</a>
 *
 */

public class FriendsCircle {
    // Problem essentially boils down to counting number of dfs required to cover all vertices.
    // Time complexity : O(u + v). Each node is visited once.
    public int findFriendsCircle(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int friendsCircleCount = 0;

        for (int u = 0; u < M.length; u++) {
            if(!visited[u]) {
                dfs(M, visited, u);
            }
        }
        return friendsCircleCount;
    }

    public void dfs(int[][] M, boolean[] visited, int u) {
        visited[u] = true;
        for (int v = 0; v < M[0].length; v++) {
            if (!visited[v] && M[u][v] == 1) {
                dfs(M, visited, v);
            }
        }
    }
}
