/*
 * Problem: 57. Insert Interval
 *
 * Statement:
 * You are given an array of non-overlapping intervals sorted
 * by their start times.
 *
 * You are also given a new interval.
 *
 * Insert the new interval into the array and merge if necessary.
 *
 * Return the resulting array of non-overlapping intervals.
 *
 * ------------------------------------------------------------
 * APPROACH: Greedy Interval Processing
 *
 * Core Insight:
 *
 * - Since intervals are already sorted:
 *   → Process them in order
 *   → Handle three clear phases:
 *       1. Intervals completely before newInterval
 *       2. Intervals overlapping with newInterval
 *       3. Intervals completely after newInterval
 *
 * ------------------------------------------------------------
 * Step-by-Step Algorithm:
 *
 * 1. Initialize:
 *      ArrayList<int[]> result
 *      i = 0
 *
 * 2. Add all intervals that end BEFORE newInterval starts:
 *
 *      while intervals[i][1] < newInterval[0]:
 *          add intervals[i] to result
 *          i++
 *
 * 3. Merge all overlapping intervals:
 *
 *      while intervals[i][0] <= newInterval[1]:
 *          newInterval.start = min(newInterval.start, intervals[i].start)
 *          newInterval.end   = max(newInterval.end,   intervals[i].end)
 *          i++
 *
 * 4. Add the merged newInterval to result
 *
 * 5. Add all remaining intervals after newInterval
 *
 * 6. Convert result list to array and return
 *
 * ------------------------------------------------------------
 * Why This Works:
 *
 * - Sorted order guarantees overlap checks are sequential
 * - Merging only happens when intervals overlap
 * - Greedy merging ensures minimal number of intervals
 *
 * ------------------------------------------------------------
 * Example Walkthrough:
 *
 * intervals = [[1,3],[6,9]]
 * newInterval = [2,5]
 *
 * Step 1:
 * - [1,3] overlaps → merge → newInterval becomes [1,5]
 *
 * Step 2:
 * - Add merged interval
 * - Add remaining intervals
 *
 * Result:
 * [[1,5],[6,9]]
 *
 * ------------------------------------------------------------
 * Edge Cases:
 *
 * - Insert at beginning
 * - Insert at end
 * - New interval covers all existing intervals
 * - No overlap at all
 *
 * ------------------------------------------------------------
 * Time Complexity:
 *
 * - O(n)
 *
 * ------------------------------------------------------------
 * Space Complexity:
 *
 * - O(n) (result list)
 *
 * ------------------------------------------------------------
 * Pattern Recognition:
 *
 * This problem follows the:
 *   "Interval Merge / Insert" pattern
 *
 * Seen in:
 * - Merge Intervals
 * - Meeting Room problems
 * - Calendar scheduling
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> arr = new ArrayList<>();
        int i = 0;

        // 1. Add all intervals before overlap
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            arr.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add merged interval
        arr.add(newInterval);

        // 3. Add remaining intervals
        while (i < intervals.length) {
            arr.add(intervals[i]);
            i++;
        }

        // Convert ArrayList to array
        return arr.toArray(new int[arr.size()][]);
    }
}
