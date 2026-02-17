/*
 * Problem: 102. Binary Tree Level Order Traversal
 *
 * Question:
 * - Given the root of a binary tree,
 *   return its level order traversal.
 * - That means return values level-by-level
 *   from left to right.
 *
 * Given:
 * - TreeNode root
 *
 * Task:
 * - Return List<List<Integer>>
 *   where each inner list represents
 *   one level of the tree.
 *
 * -------------------------------------------------------
 * What is happening?
 *
 * We need to traverse the tree level by level.
 *
 * Instead of going deep first (like DFS),
 * we go level-wise:
 *
 * Level 0 → root
 * Level 1 → root's children
 * Level 2 → grandchildren
 *
 * This is exactly what BFS (Breadth First Search) does.
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use a Queue (FIFO).
 *
 * Why?
 * Because BFS processes nodes in the order
 * they are discovered.
 *
 * Important Trick:
 * Before processing a level,
 * store queue.size().
 *
 * That size tells how many nodes
 * belong to the current level.
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. If root is null → return empty list.
 *
 * 2. Create:
 *      - Result list
 *      - Queue
 *
 * 3. Add root to queue.
 *
 * 4. While queue not empty:
 *
 *      a) Store size = queue.size()
 *         (Number of nodes in current level)
 *
 *      b) Create new list for current level
 *
 *      c) Run loop size times:
 *
 *              Remove node from queue
 *              Add its value to current list
 *
 *              If left child exists → add to queue
 *              If right child exists → add to queue
 *
 *      d) Add current level list to result
 *
 * 5. Return result.
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 *        3
 *       / \
 *      9  20
 *         /  \
 *        15   7
 *
 * Step-by-step:
 *
 * Queue = [3]
 *
 * Level 0:
 *   size = 1
 *   remove 3
 *   add 9, 20
 *   result = [[3]]
 *
 * Level 1:
 *   size = 2
 *   remove 9
 *   remove 20
 *   add 15, 7
 *   result = [[3], [9,20]]
 *
 * Level 2:
 *   size = 2
 *   remove 15
 *   remove 7
 *   result = [[3], [9,20], [15,7]]
 *
 * Output:
 * [[3], [9,20], [15,7]]
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 * (Each node is visited once)
 *
 * -------------------------------------------------------
 * Space Complexity:
 * O(n)
 * (Queue + Result list)
 *
 * -------------------------------------------------------
 * Pattern:
 * BFS (Breadth First Search)
 * Level Order Traversal
 * Queue-based Tree Traversal
 */
