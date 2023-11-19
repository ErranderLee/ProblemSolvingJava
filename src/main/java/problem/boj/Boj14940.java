package problem.boj;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj14940 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class LocAndDist {
        Loc loc;
        int dist;

        public LocAndDist(Loc loc, int dist) {
            this.loc = loc;
            this.dist = dist;
        }
    }

    static Loc findGoal(List<List<Integer>> maps, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps.get(i).get(j) == 2) {
                    return new Loc(i, j);
                }
            }
        }

        return null;
    }

    static boolean validateLoc(int n, int m, Loc newLoc) {
        if (newLoc.x < 0 || newLoc.x >= n) {
            return false;
        }

        if (newLoc.y < 0 || newLoc.y >= m) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        String[] size = input.readLine().split(" ");
        int n = Integer.parseInt(size[0]); // 세로
        int m = Integer.parseInt(size[1]);

        List<List<Integer>> maps = new ArrayList<>();
        int[][] result = new int[n][m];
        int[][] visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            maps.add(Arrays.stream(input.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        Loc goal = findGoal(maps, n, m);
        Queue<LocAndDist> queue = new LinkedList<>();
        queue.add(new LocAndDist(goal, 0));
        visit[goal.x][goal.y] = 1;
        List<Loc> dxdy = new ArrayList<>();
        dxdy.addAll(Arrays.asList(new Loc(-1, 0), new Loc(1, 0), new Loc(0, -1), new Loc(0, 1)));

        while (!queue.isEmpty()) {
            LocAndDist pop = queue.poll();

            dxdy.forEach(dxdyloc -> {
                Loc newLoc = new Loc(dxdyloc.x + pop.loc.x, dxdyloc.y + pop.loc.y);
                if (validateLoc(n, m, newLoc) && maps.get(newLoc.x).get(newLoc.y) != 0 && visit[newLoc.x][newLoc.y] != 1) {
                    queue.add(new LocAndDist(newLoc, pop.dist + 1));
                    result[newLoc.x][newLoc.y] = pop.dist + 1;
                    visit[newLoc.x][newLoc.y] = 1;
                }
            });
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] != 1 && maps.get(i).get(j) != 0) {
                    result[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output.write(result[i][j] + " ");
            }
            output.write("\n");
        }

        output.flush();
        output.close();
    }
}
