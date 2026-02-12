/* 
 * Problem: 71. Simplify Path
 *
 * Given:
 * - A string path representing an absolute path in Unix-style file system
 *
 * Task:
 * - Return the simplified canonical path.
 *
 * Rules:
 * 1. "."  → Current directory (ignore)
 * 2. ".." → Go to parent directory (pop)
 * 3. "//" → Multiple slashes treated as single slash
 * 4. Path must:
 *        - Start with single '/'
 *        - No trailing slash (unless root "/")
 *
 * Example:
 * Input:  "/home/"
 * Output: "/home"
 *
 * Input:  "/a/./b/../../c/"
 * Output: "/c"
 *
 * Input:  "/../"
 * Output: "/"
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * This is a Stack problem because:
 *
 * - ".." means go back → remove last directory
 * - That is exactly stack pop (LIFO behavior)
 *
 * Strategy:
 *
 * 1. Split path by "/"
 * 2. Traverse each part:
 *
 *      Case 1: "" or "." → Ignore
 *
 *      Case 2: ".."
 *              If stack not empty → pop
 *
 *      Case 3: Valid directory name
 *              Push into stack
 *
 * 3. Reconstruct path from stack
 *
 * -------------------------------------------------------
 * Why Stack Works?
 *
 * Example:
 * "/a/./b/../../c/"
 *
 * After split → ["", "a", ".", "b", "..", "..", "c", ""]
 *
 * Process:
 * "a"  → push
 * "."  → ignore
 * "b"  → push
 * ".." → pop "b"
 * ".." → pop "a"
 * "c"  → push
 *
 * Stack = ["c"]
 *
 * Final path = "/c"
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * 1. Split path by "/"
 * 2. Create empty stack
 * 3. For each token:
 *        If ".." and stack not empty → pop
 *        Else if token is valid directory → push
 *        Else ignore
 * 4. Build result string:
 *        Append "/" + each element
 * 5. If empty → return "/"
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 * (Split + single traversal)
 *
 * Space Complexity:
 * O(n)
 * (Stack storage)
 *
 * Pattern:
 * Stack + String Processing
 */

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {

        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();

        for (String token : arr) {

            if (token.equals("") || token.equals(".")) {
                // Ignore empty and current directory
                continue;
            }

            else if (token.equals("..")) {
                // Go to parent directory
                if (!st.isEmpty()) {
                    st.pop();
                }
            }

            else {
                // Valid directory name
                st.push(token);
            }
        }

        // Build final path
        StringBuilder sb = new StringBuilder();

        for (String dir : st) {
            sb.append("/");
            sb.append(dir);
        }

        // If empty → root
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
