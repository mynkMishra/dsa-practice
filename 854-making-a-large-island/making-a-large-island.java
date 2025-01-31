class Solution {

    public int largestIsland(int[][] grid) {

        int N = grid.length;
        int M = grid[0].length;

        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2;

        // Step 1: Mark all islands and calculate their sizes
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 1) {
                    islandSizes.put(islandId, exploreIsland(grid, islandId, i, j));
                    ++islandId;
                }
            }
        }

        // If there are no islands, return 1
        if (islandSizes.isEmpty()) {
            return 1;
        }
        // If the entire grid is one island, return its size or size + 1
        if (islandSizes.size() == 1) {
            --islandId;
            return (islandSizes.get(islandId) == N * M)
                ? islandSizes.get(islandId)
                : islandSizes.get(islandId) + 1;
        }

        int maxIslandSize = 1;

        // Step 2: Try converting every 0 to 1 and calculate the resulting island size
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0) {
                    int currentIslandSize = 1;
                    Set<Integer> neighboringIslands = new HashSet<>();

                    // Check down
                    if (i + 1 < N && grid[i + 1][j] > 1) {
                        neighboringIslands.add(grid[i + 1][j]);
                    }

                    // Check up
                    if (i - 1 >= 0 && grid[i - 1][j] > 1) {
                        neighboringIslands.add(grid[i - 1][j]);
                    }

                    // Check right
                    if (j + 1 < M && grid[i][j + 1] > 1) {
                        neighboringIslands.add(grid[i][j + 1]);
                    }

                    // Check left
                    if (j - 1 >= 0 && grid[i][j - 1] > 1) {
                        neighboringIslands.add(grid[i][j - 1]);
                    }

                    // Sum the sizes of all unique neighboring islands
                    for (int id : neighboringIslands) {
                        currentIslandSize += islandSizes.get(id);
                    }

                    maxIslandSize = Math.max(maxIslandSize, currentIslandSize);
                }
            }
        }

        return maxIslandSize;
    }

    private int exploreIsland(
        int[][] grid,
        int islandId,
        int currentRow,
        int currentColumn
    ) {
        if (
            currentRow < 0 ||
            currentRow >= grid.length ||
            currentColumn < 0 ||
            currentColumn >= grid[0].length ||
            grid[currentRow][currentColumn] != 1
        ) return 0;

        grid[currentRow][currentColumn] = islandId;
        return (
            1 +
            exploreIsland(grid, islandId, currentRow + 1, currentColumn) +
            exploreIsland(grid, islandId, currentRow - 1, currentColumn) +
            exploreIsland(grid, islandId, currentRow, currentColumn + 1) +
            exploreIsland(grid, islandId, currentRow, currentColumn - 1)
        );
    }
}