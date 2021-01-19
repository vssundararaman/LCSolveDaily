package com.vidya.leetcode.fb;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2; int[][] prerequisites = {{1,0},{0,1}};

        System.out.println(canFinish(numCourses,prerequisites));
    }

   static boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[][] graph = new boolean[numCourses][numCourses];
        int[] inDegree = new int[numCourses];


        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]][prerequisites[i][0]]=true;
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            count++;

            int courseTaken = queue.poll();
            for(int i=0;i<graph.length;i++){
                if(graph[courseTaken][i]){
                    inDegree[i]--;
                    if(inDegree[i]==0){
                        queue.add(i);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
