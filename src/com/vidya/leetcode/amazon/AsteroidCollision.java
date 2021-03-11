package com.vidya.leetcode.amazon;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. Asteroid Collision
 * <p>
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 * <p>
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 * <p>
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * Example 4:
 * <p>
 * Input: asteroids = [-2,-1,1,2]
 * Output: [-2,-1,1,2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * <p>
 * Time Complexity O(N)
 * Space Complexity O(N)
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            //Inserting Positive Values
            if(stack.isEmpty() || asteroids[i]> 0){
                stack.push(asteroids[i]);
            }else{
                while (true){
                    int peek = stack.peek();

                    if( peek < 0){
                        stack.push(asteroids[i]);
                        break;
                    }else if(peek == asteroids[i]){
                        stack.pop();
                        break;
                    }else if( peek > -asteroids[i]){
                        break;
                    }else {
                        stack.pop();
                        if(!stack.isEmpty()){
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }

        }

        int[] outputArray = new int[stack.size()];
        for(int i = stack.size()-1; i >=0; i--){
            outputArray[i] = stack.pop();
        }

        return outputArray;
    }
}
