/*
 * Problem: 1701. Average Waiting Time
 *
 * Task:
 * Given customers arriving with cooking times,
 * return the average waiting time.
 *
 * Waiting Time =
 *   (service finish time) - (arrival time)
 *
 * ------------------------------------------------------------
 * Approach: Simulation (Greedy Time Tracking)
 *
 * Key Idea:
 * - Track when the chef becomes free (idle_time)
 * - If chef is idle, start at arrival time
 * - Else, continue cooking
 *
 * ------------------------------------------------------------
 * Algorithm:
 *
 * 1. Initialize:
 *    idle_time = 0
 *    total_wait = 0
 *
 * 2. For each customer [arrival, cookTime]:
 *    - If idle_time <= arrival:
 *         idle_time = arrival + cookTime
 *      Else:
 *         idle_time += cookTime
 *
 *    - total_wait += idle_time - arrival
 *
 * 3. Return total_wait / number of customers
 *
 * ------------------------------------------------------------
 * Dry Run:
 *
 * customers = [[1,2],[2,5],[4,3]]
 *
 * Customer 1:
 * idle_time = 1 + 2 = 3
 * wait = 3 - 1 = 2
 *
 * Customer 2:
 * idle_time = 3 + 5 = 8
 * wait = 8 - 2 = 6
 *
 * Customer 3:
 * idle_time = 8 + 3 = 11
 * wait = 11 - 4 = 7
 *
 * Total wait = 15
 * Average = 15 / 3 = 5.0
 *
 * ------------------------------------------------------------
 * Why It Works:
 * - Single timeline tracks chef availability
 * - Customers handled in arrival order
 *
 * ------------------------------------------------------------
 * Time:  O(n)
 * Space: O(1)
 *
 * ------------------------------------------------------------
 * Pattern:
 * Timeline Simulation / Greedy Scheduling
 */

class Solution {
    public double averageWaitingTime(int[][] customers) {

        int idle_time = 0;
        long wt_time = 0;

        for (int[] customer : customers) {

            if (idle_time <= customer[0]) {
                idle_time = customer[0] + customer[1];
            } else {
                idle_time += customer[1];
            }

            wt_time += (idle_time - customer[0]);
        }

        return wt_time / (double) customers.length;
    }
}
