/**
 * Open the Lock
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. 
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * 
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * 
 * 
 */
package com.ovelychko;

import java.util.HashSet;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class OpenTheLock {
    
    public static int openLock(String[] deadends, String target) {
        HashSet<String> hset = new HashSet<>();
        int steps = 0;
        Deque<String> list = new LinkedList<>();
        list.add("0000");
        Deque<String> next = new LinkedList<>();
        while (!list.isEmpty()) {

            String current = list.pop();

            if (!Arrays.asList(deadends).contains(current)) {
                if (target.equals(current)) {
                    return steps;
                }

                for (int i = 0; i < 4; i++) {
                    // +1xxx
                    int test = (int) current.charAt(i);
                    test++;
                    if (test > '9') test = test - 10;
                    String tests = current.substring(0, i) + (char) test + current.substring(i + 1);
                    if (hset.add(tests))
                        next.push(tests);

                    // -1xxx
                    test = (int) current.charAt(i);
                    test--;
                    if (test < '0') test = test + 10;

                    tests = current.substring(0, i) + (char) test + current.substring(i + 1);
                    if (hset.add(tests))
                        next.push(tests);
                }
            }

            if (list.isEmpty()) {
                list = next;
                next = new LinkedList<>();
                steps++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("OpenTheLock");
    }
}
