/*
 * Problem: 452. Minimum Number of Arrows to Burst Balloons
 *
 * Statement:
 * You are given a 2D array `points` where:
 *   points[i] = [xStart, xEnd]
 *
 * Each balloon spans from xStart to xEnd on the X-axis.
 *
 * An arrow shot at position x can burst all balloons
 * where xStart <= x <= xEnd.
 *
 * Return the minimum number of arrows required
 * to burst all balloons.
 *
 * ------------------------------------------------------------
 * APPROACH: Greedy Interval Scheduling (Sort by End)
 *
 * Core Greedy Insight:
 *
 * - To minimize arrows, always shoot an arrow at the
 *   earliest possible end point
 *
 * - This maximizes the number of balloons burst
 *   by a single arrow
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Sort all balloons by their end coordinate (xEnd)
 *
 * 2. Initialize:
 *      arrows = 1
 *      prevEnd = end of the first balloon
 *
 * 3. Traverse balloons from the second one:
 *
 *    a) If current balloon starts AFTER prevEnd:
 *         - It cannot be burst by the current arrow
 *         - Shoot a new arrow
 *         - Update prevEnd
 *
 *    b) Else:
 *         - Current balloon overlaps
 *         - Burst it with the existing arrow
 *
 * 4. Return arrows
 *
 * ------------------------------------------------------------
 * Why This Works (Greedy Proof Intuition):
 *
 * - Shooting at the smallest end keeps maximum future overlap
 * - Any later shot would reduce overlap opportunities
 * - This greedy choice ensures minimum arrows
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * points = [[10,16],[2,8],[1,6],[7,12]]
 *
 * After sorting by end:
 * [[1,6],[2,8],[7,12],[10,16]]
 *
 * Steps:
 * - Arrow at 6 bursts [1,6] and [2,8]
 * - Next balloon [7,12] starts after 6 → new arrow
 * - Arrow at 12 bursts [7,12] and [10,16]
 *
 * Answer = 2
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Single balloon
 * - All balloons overlapping
 * - Completely disjoint balloons
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - Sorting: O(n log n)
 * - Traversal: O(n)
 *
 * Overall:
 *   O(n log n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(1) extra space (sorting aside)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Greedy Interval Scheduling" pattern
 *
 * Seen in:
 * - Activity selection
 * - Meeting room problems
 * - Interval coverage problems
 */

class Solution {
    public int findMinArrowShots(int[][] points) {

        // Sort balloons by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int prevEnd = points[0][1];

        // Traverse remaining balloons
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }

        return arrows;
    }
}
