/**
 * Given an n x n binary matrix grid, return the length of the shortest
 * clear path in the matrix. If there is no clear path, return -1.
 * <p>
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */

package com.ovelychko;

import java.util.ArrayDeque;

public class ShortestPathInBinaryMatrix {

    private static int[][] visited;

    private static int shortestPathBinaryMatrix(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        if (grid[0][0] == 1) return -1;
        return helper(grid, 0, 0);
    }

    private static int helper(int[][] grid, int y, int x) {

        visited[y][x] = 1;
        int res;
        int localRes = -1;

/*        System.out.println("------IN-------" + x + " " + y);
        for (int[] k : visited) {
            for (int p : k)
                System.out.print(p + " ");
            System.out.println();
        }*/

        if (y == grid.length - 1 && x == grid[0].length - 1) {
            // System.out.println("END");
            System.out.println("------END-------");
            for (int[] k : visited) {
                for (int p : k)
                    System.out.print(p + " ");
                System.out.println();
            }
            visited[y][x] = 0;
            return 1;
        } else {

            if (y < grid.length - 1 && visited[y + 1][x] == 0 && grid[y + 1][x] == 0) {
                res = helper(grid, y + 1, x);
                if (res > -1) {
                    res++;
                    localRes = res;
                    // return (res + 1);
                }
            }

            if (y > 0 && visited[y - 1][x] == 0 && grid[y - 1][x] == 0) {
                res = helper(grid, y - 1, x);
                if (res > -1) {
                    res++;
                    localRes = (localRes == -1) ? res : Math.min(res, localRes);
                    // return (res + 1);
                }
            }

            if (x < grid[0].length - 1) {
                if (visited[y][x + 1] == 0 && grid[y][x + 1] == 0) {
                    res = helper(grid, y, x + 1);
                    if (res > -1) {
                        res++;
                        localRes = (localRes == -1) ? (res) : Math.min(res, localRes);
                        // return (res + 1);
                    }
                }

                if (y < grid.length - 1 && visited[y + 1][x + 1] == 0 && grid[y + 1][x + 1] == 0) {
                    res = helper(grid, y + 1, x + 1);
                    if (res > -1) {
                        res++;
                        localRes = (localRes == -1) ? (res) : Math.min(res, localRes);
                        // return (res + 1);
                    }
                }

                if (y > 0 && visited[y - 1][x + 1] == 0 && grid[y - 1][x + 1] == 0) {
                    res = helper(grid, y - 1, x + 1);
                    if (res > -1) {
                        res++;
                        localRes = (localRes == -1) ? (res) : Math.min(res, localRes);
                        // return (res + 1);
                    }
                }
            }

            if (x > 0) {

                if (visited[y][x - 1] == 0 && grid[y][x - 1] == 0) {
                    res = helper(grid, y, x - 1);
                    if (res > -1) {
                        res++;
                        localRes = (localRes == -1) ? (res) : Math.min(res, localRes);
                        // return (res + 1);
                    }
                }

                if (y < grid.length - 1 && visited[y + 1][x - 1] == 0 && grid[y + 1][x - 1] == 0) {
                    res = helper(grid, y + 1, x - 1);
                    if (res > -1) {
                        res++;
                        localRes = (localRes == -1) ? (res) : Math.min(res, localRes);
                        // return (res + 1);
                    }
                }

                if (y > 0 && visited[y - 1][x - 1] == 0 && grid[y - 1][x - 1] == 0) {
                    res = helper(grid, y - 1, x - 1);
                    if (res > -1) {
                        res++;
                        localRes = (localRes == -1) ? (res) : Math.min(res, localRes);
                        // return (res + 1);
                    }
                }
            }
        }

        // System.out.println("--false");
        visited[y][x] = 0;
        // System.out.println("------BACK-------" + x + " " + y);
        return localRes;
    }

    static class Node {
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int x;
        public int y;
    }

    private static int shortestPathBinaryMatrixNew(int[][] grid) {

        if (grid[0][0] == 1) return -1;

        visited = new int[grid.length][grid[0].length];

        ArrayDeque<Node> queue = new ArrayDeque<>();
        ArrayDeque<Node> next = new ArrayDeque<>();

        queue.push(new Node(0, 0));
        int count = 1;
        while (!queue.isEmpty()) {

            Node nd = queue.pop();
            visited[nd.y][nd.x] = 1;

            if (nd.y == grid.length - 1 && nd.x == grid[0].length - 1) {
                /*System.out.println("------END-------");
                for (int[] k : visited) {
                    for (int p : k)
                        System.out.print(p + " ");
                    System.out.println();
                }*/
                return count;
            } else {

                if (nd.y < grid.length - 1 && visited[nd.y + 1][nd.x] == 0 && grid[nd.y + 1][nd.x] == 0) {
                    next.push(new Node(nd.y + 1, nd.x));
                }

                if (nd.y > 0 && visited[nd.y - 1][nd.x] == 0 && grid[nd.y - 1][nd.x] == 0) {
                    next.push(new Node(nd.y - 1, nd.x));
                }

                if (nd.x < grid[0].length - 1) {
                    if (visited[nd.y][nd.x + 1] == 0 && grid[nd.y][nd.x + 1] == 0) {
                        next.push(new Node(nd.y, nd.x + 1));
                    }

                    if (nd.y < grid.length - 1 && visited[nd.y + 1][nd.x + 1] == 0 && grid[nd.y + 1][nd.x + 1] == 0) {
                        next.push(new Node(nd.y + 1, nd.x + 1));
                    }

                    if (nd.y > 0 && visited[nd.y - 1][nd.x + 1] == 0 && grid[nd.y - 1][nd.x + 1] == 0) {
                        next.push(new Node(nd.y - 1, nd.x + 1));
                    }
                }

                if (nd.x > 0) {

                    if (visited[nd.y][nd.x - 1] == 0 && grid[nd.y][nd.x - 1] == 0) {
                        next.push(new Node(nd.y, nd.x - 1));
                    }

                    if (nd.y < grid.length - 1 && visited[nd.y + 1][nd.x - 1] == 0 && grid[nd.y + 1][nd.x - 1] == 0) {
                        next.push(new Node(nd.y + 1, nd.x - 1));
                    }

                    if (nd.y > 0 && visited[nd.y - 1][nd.x - 1] == 0 && grid[nd.y - 1][nd.x - 1] == 0) {
                        next.push(new Node(nd.y - 1, nd.x - 1));
                    }
                }
            }


            if (queue.isEmpty()) {
                queue = next;
                next = new ArrayDeque<>();
                count++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
/*        int[][] y = {{0, 0, 1, 0, 0, 0, 0},
                    {0, 1, 0, 0, 0, 0, 1},
                    {0, 0, 1, 0, 1, 0, 0},
                    {0, 0, 0, 1, 1, 1, 0},
                    {1, 0, 0, 1, 1, 0, 0},
                    {1, 1, 1, 1, 1, 0, 1},
                    {0, 0, 1, 0, 0, 0, 0}};
        System.out.println(shortestPathBinaryMatrixNew(y)); */

        int[][] x = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrixNew(x));

    }
}
