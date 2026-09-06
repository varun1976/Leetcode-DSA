class Node {
    int row, col, turns, dir, cost;

    Node(int row, int col, int turns, int dir, int cost) {
        this.row = row;
        this.col = col;
        this.turns = turns;
        this.dir = dir;
        this.cost = cost;
    }
}

class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int INF = Integer.MAX_VALUE;
        int[][][][] dist = new int[m][n][k + 1][5];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int t = 0; t <= k; t++) {
                    Arrays.fill(dist[i][j][t], INF);
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        dist[0][0][0][4] = grid[0][0];
        pq.add(new Node(0, 0, 0, 4, grid[0][0]));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            int row = curr.row;
            int col = curr.col;
            int turns = curr.turns;
            int dir = curr.dir;
            int cost = curr.cost;

            if(cost != dist[row][col][turns][dir]) continue;

            if(row == m - 1 && col == n - 1) {
                return cost;
            }

            for(int newDir = 0; newDir < 4; newDir++) {
                int newRow = row + dr[newDir];
                int newCol = col + dc[newDir];

                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    continue;
                }

                int newTurns = turns;

                if(dir != 4 && dir != newDir) {
                    newTurns++;
                }

                if(newTurns > k) {
                    continue;
                }

                int newCost = cost + grid[newRow][newCol];

                if(newCost < dist[newRow][newCol][newTurns][newDir]) {
                    dist[newRow][newCol][newTurns][newDir] = newCost;
                    pq.add(new Node(newRow, newCol, newTurns, newDir, newCost));
                }
            }
        }

        return -1;
    }
}