package com.solo;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};

        Solution solution = new Solution();
        solution.wallsAndGates(array);
    }
}
