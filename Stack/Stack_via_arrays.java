/* 
 * Problem: Implement Stack using Array
 *
 * Given:
 * - Implement a Stack data structure manually using array
 *
 * Task:
 * - Implement basic stack operations:
 *      push()
 *      pop()
 *      peek()
 *      isEmpty()
 *      size()
 *      print()
 *
 * -------------------------------------------------------
 * Core Idea:
 *
 * Stack follows:
 *      LIFO (Last In First Out)
 *
 * We maintain:
 *      - int[] stack → to store elements
 *      - int top → index of top element
 *
 * Initially:
 *      top = -1 (means stack is empty)
 *
 * -------------------------------------------------------
 * Important Fixes in Your Code:
 *
 * 1. Class name should start with capital letter (Java convention)
 * 2. print() method formatting corrected
 * 3. isEmpty() should check (top == -1)
 * 4. Added overflow & underflow clarity
 *
 * -------------------------------------------------------
 * Algorithm:
 *
 * push(element):
 *      If top == size - 1 → Overflow
 *      Else:
 *          top++
 *          stack[top] = element
 *
 * pop():
 *      If empty → Underflow
 *      Else:
 *          return stack[top--]
 *
 * peek():
 *      If empty → return special value
 *      Else:
 *          return stack[top]
 *
 * -------------------------------------------------------
 * Time Complexity:
 * push() → O(1)
 * pop()  → O(1)
 * peek() → O(1)
 *
 * Space Complexity:
 * O(n)
 *
 * Pattern:
 * Array Implementation + LIFO
 */

import java.util.*;

public class StackImplementation {

    int[] stack;
    int size;
    int top;

    public StackImplementation(int stackSize){
        stack = new int[stackSize];
        size = stackSize;
        top = -1;
    }

    public void push(int element){
        if(top == size - 1){
            System.out.println("Stack Overflow (Size Full)");
            return;
        }
        stack[++top] = element;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow (Empty)");
            return Integer.MIN_VALUE;
        }
        return stack[top--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top + 1;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return;
        }

        for(int i = 0; i <= top; i++){
            System.out.print(stack[i]);
            if(i != top){
                System.out.print(" , ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 5;
        StackImplementation st = new StackImplementation(n);

        System.out.println("Is Stack empty? " + st.isEmpty());

        st.push(5);
        st.push(2);

        System.out.println("Top element: " + st.peek());

        st.pop();

        System.out.println("After pop operation: " + st.peek());

        st.print();
    }
}
