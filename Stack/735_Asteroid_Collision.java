/*
 * Problem: 735. Asteroid Collision
 *
 * Given:
 * - int[] asteroids
 * - Each value represents size and direction
 *
 * Direction:
 *      Positive  → moving right
 *      Negative  → moving left
 *
 * Task:
 * - Simulate collisions
 * - Return final state of asteroids
 *
 * -------------------------------------------------------
 * Collision Rule:
 *
 * Collision happens ONLY when:
 *      stackTop > 0  AND  current < 0
 *
 * Meaning:
 *      Right-moving asteroid meets left-moving asteroid
 *
 * -------------------------------------------------------
 * Collision Outcomes:
 *
 * Let:
 *      top = stack.peek()
 *      curr = current asteroid
 *
 * Compare sizes using:
 *      abs(top) vs abs(curr)
 *
 * 1. |top| < |curr|
 *      → top explodes
 *      → pop stack
 *      → continue checking
 *
 * 2. |top| == |curr|
 *      → both explode
 *      → pop stack
 *      → stop (do NOT push current)
 *
 * 3. |top| > |curr|
 *      → current explodes
 *      → stop
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Use Stack because:
 * - We must compare current asteroid
 *   with the LAST surviving asteroid.
 *
 * LIFO helps simulate chain collisions.
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Create empty stack
 *
 * 2. Traverse asteroids:
 *
 *      While:
 *          stack not empty
 *          AND current < 0
 *          AND stack.peek() > 0
 *
 *          Handle collision cases
 *
 *      If current still alive:
 *          push to stack
 *
 * 3. Convert stack to array (reverse order)
 *
 * -------------------------------------------------------
 * Example:
 *
 * Input:
 * [5, 10, -5]
 *
 * Process:
 *
 * 5  → push [5]
 * 10 → push [5,10]
 * -5 → collision with 10
 *        10 > 5 → -5 explodes
 *
 * Output:
 * [5,10]
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Stack + Simulation
 */

class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for(int i : nums){

            while(!st.isEmpty() && i<0 && st.peek()>0){   // collision condition: Collision tabhi hoga if stack is empty, stack ka top element +ve ho and current ith element -ive ho
                int sum = i+st.peek();
                if(sum<0){
                    st.pop();
                }

                else if(sum==0){
                    st.pop();
                    i=0;                    // break and come out of loop
                }

                else{
                    i=0;                   // break and come out of loop
                }

            }

            if(i!=0) st.push(i);

        }
// stack ke elements ko array mein ulta daal diya

        int[] arr = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            arr[i] = st.pop();
        }
        return arr;
    }
}
