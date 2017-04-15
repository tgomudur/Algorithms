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

// Other ways to do it.
// class StackElement {
//     int value;
//     int min;
//     public StackElement(int value, int min) {
//         this.value = value;
//         this.min = min;
//     }
// }
// public class MinStack {
//     Stack<StackElement> stack;

//     /** initialize your data structure here. */
//     public MinStack() {
//         stack = new Stack<>();;
//     }

//     public void push(int x) {
//         int min = (stack.isEmpty())? x : Math.min(stack.peek().min, x);
//         stack.push(new StackElement(x, min));
//     }

//     public void pop() {
//         if (!stack.isEmpty())
//             stack.pop();
//     }

//     public int top() {
//         return stack.peek().value;
//     }

//     public int getMin() {
//         return stack.peek().min;
//     }
// }

// public class MinStack {
//     Stack<Integer> valueStack;
//     Stack<Integer> minStack;

//     /** initialize your data structure here. */
//     public MinStack() {
//         valueStack = new Stack<>();
//         minStack = new Stack<>();
//     }

//     public void push(int x) {
//         valueStack.push(x);
//         if (!minStack.isEmpty()) minStack.push(Math.min(minStack.peek(), x));
//         else minStack.push(x);
//     }

//     public void pop() {
//         if (!valueStack.isEmpty() && !minStack.isEmpty()) {
//             valueStack.pop();
//             minStack.pop();
//         }
//     }

//     public int top() {
//         return valueStack.peek();
//     }

//     public int getMin() {
//         return minStack.peek();
//     }
// }

