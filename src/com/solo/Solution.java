package com.solo;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public void wallsAndGates(int[][] rooms) {
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (rooms[row][col] == 0) {
                    bfs(rooms, row, col);
                }
            }
        }
    }

    public void bfs(int[][] rooms, int row, int col) {
        int step = 1;
        Queue<Pair> queue = new LinkedList();
        addNeighbors(queue, rooms, new Pair(row, col));
        Pair pair;
        while (queue.size() > 0) {
            int roundSize = queue.size();
            for (int round = 0; round < roundSize; round++) {
                pair = queue.poll();
                int val = rooms[pair.row][pair.col];
                if (val == -1) {
                    continue;
                }
                if (val == 0) {
                    continue;
                }
                if (step < val) {
                    rooms[pair.row][pair.col] = step;
                    addNeighbors(queue, rooms, pair);
                }
            }
            step++;
        }
    }

    private void addNeighbors(Queue queue, int[][] rooms, Pair pair) {
        int row = pair.row;
        int col = pair.col;
        int width = rooms[0].length;
        int height = rooms.length;
        if (row - 1 >= 0) {//top
            queue.offer(new Pair(row - 1, col));
        }
        if ((col + 1) < width) {//right
            queue.offer(new Pair(row, col + 1));
        }
        if ((row + 1) < height) {//bottom
            queue.offer(new Pair(row + 1, col));
        }
        if ((col - 1) >= 0) {//left
            queue.offer(new Pair(row, col - 1));
        }
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}