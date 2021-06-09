/**
 * Max Area of Island
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * 
 */

package com.ovelychko;

public class MaxAreaOfIsland {
        
    private static int res = 0;
    
    public static int maxAreaOfIsland(int[][] grid) {
        res = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                int val = helper(grid, i, j); 
                if (val > res) res = val;
            }
        }
        
        return res;
    }
    
    private static int helper(int[][] grid, int i, int j) {
        int res = 0;
        if (grid[i][j] == 1) {
            
            res++;
            grid[i][j] = -1;
            
            if (j+1<grid[i].length && grid[i][j+1]==1)
                res += helper(grid, i, j+1);
            
            if (i+1<grid.length && grid[i+1][j]==1)
                res += helper(grid, i+1, j);
            
            if (j>0 && grid[i][j-1]==1)
                res += helper(grid, i, j-1);
            
            if (i>0 && grid[i-1][j]==1)
                res += helper(grid, i-1, j);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println("MaxAreaOfIsland: " + maxAreaOfIsland(grid));
    }
}
