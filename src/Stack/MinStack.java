package Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * https://leetcode.com/problems/min-stack/#/description
 */
public class MinStack {
    Stack<Integer> stack;
    int min;

    public Stack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (min == stack.pop())
            min = stack.pop()
    }

    public int getMin() {
        return min;
    }

    public int getTop() {
        return stack.peek();
    }
}
