package com.vidya.leetcode.fb;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{-2, 2}, {1, 3}, {-1, 1}};
        int k = 2;

        System.out.println(Arrays.deepToString(kCloset(points, k)));
    }

    static int[][] kCloset(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) -
                (a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        int[][] result = new int[k][2];

        while (k-- > 0) {
            result[k] = maxHeap.remove();
        }

        return result;
    }
}
