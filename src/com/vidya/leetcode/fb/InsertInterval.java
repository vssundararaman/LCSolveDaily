package com.vidya.leetcode.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        int intervals[][] = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));

    }

    static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        //Assign
        int[] toAdd = newInterval;

        for (int i = 0; i < intervals.length; i++) {


            if (intervals[i][0] > newInterval[1]) {
                ans.add(toAdd);
                toAdd = intervals[i];
            }


            else if (intervals[i][1] >= toAdd[0])
                toAdd = new int[]{Math.min(intervals[i][0], toAdd[0]),
                        Math.max(intervals[i][1], toAdd[1])
            };

            else {

                ans.add(intervals[i]);
            }



        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }

}
