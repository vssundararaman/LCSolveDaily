package com.vidya.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};

        System.out.println(minMeetingRooms(intervals));
    }

    static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] interval : intervals) {

//            if(!queue.isEmpty () && queue.peek ()[1] <= interval[0]){
//                queue.poll ();
//            }

            queue.add(interval);
        }

        for (int[] interval : queue) {
            System.out.println(Arrays.toString(interval));
        }

        return queue.size();
    }
}
