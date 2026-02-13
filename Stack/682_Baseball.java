/* 
 * Problem: 682. Baseball Game
 *
 * Given:
 * - String[] operations
 *
 * Operations:
 * Integer → Add score
 * "+"     → Add sum of last two scores
 * "D"     → Add double of last score
 * "C"     → Remove last score
 *
 * Task:
 * - Return total score after all operations
 *
 * -------------------------------------------------------
 * APPROACH 1: Using ArrayList
 * -------------------------------------------------------
 *
 * Core Idea:
 * - Use dynamic array to simulate stack behavior.
 * - Always operate on the last elements.
 *
 * How It Works:
 *
 * If number:
 *      arr.add(value)
 *
 * If "C":
 *      arr.remove(last index)
 *
 * If "D":
 *      arr.add(2 × last element)
 *
 * If "+":
 *      arr.add(last + secondLast)
 *
 * Finally:
 *      Sum all elements.
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Code:
 */

import java.util.*;

class Solution_ArrayList {
    public int calPoints(String[] operations) {

        List<Integer> arr = new ArrayList<>();

        for (String s : operations) {

            int n = arr.size();

            if (s.equals("+")) {
                arr.add(arr.get(n - 1) + arr.get(n - 2));
            }

            else if (s.equals("C")) {
                arr.remove(n - 1);
            }

            else if (s.equals("D")) {
                arr.add(arr.get(n - 1) * 2);
            }

            else {
                arr.add(Integer.parseInt(s));
            }
        }

        int sum = 0;
        for (int score : arr) {
            sum += score;
        }

        return sum;
    }
}


/* 
 * -------------------------------------------------------
 * APPROACH 2: Using Stack (Recommended)
 * -------------------------------------------------------
 *
 * Core Idea:
 * - This is naturally a stack problem.
 * - Use LIFO behavior directly.
 *
 * How It Works:
 *
 * If number:
 *      push
 *
 * If "C":
 *      pop
 *
 * If "D":
 *      push(2 × peek)
 *
 * If "+":
 *      pop top
 *      peek second
 *      push top back
 *      push sum
 *
 * Finally:
 *      Pop all and sum.
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Code:
 */

class Solution_Stack {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();

        for (String s : operations) {

            if (s.equals("C")) {
                st.pop();
            }

            else if (s.equals("D")) {
                st.push(2 * st.peek());
            }

            else if (s.equals("+")) {

                int top = st.pop();
                int second = st.peek();

                st.push(top);
                st.push(top + second);
            }

            else {
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}
