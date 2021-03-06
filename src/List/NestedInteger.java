package List;

import java.util.Iterator;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//public class NestedIterator implements Iterator<Integer> {
//    Stack<ListIterator<NestedInteger>> stack;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        this.stack = new Stack<>();
//        this.stack.push(nestedList.listIterator());
//    }
//
//    @Override
//    public Integer next() {
//        if (hasNext())
//            return stack.peek().next().getInteger();
//        return null;
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (!stack.isEmpty()) {
//            if (!stack.peek().hasNext())
//                stack.pop();
//            else {
//                NestedInteger top = stack.peek().next();
//                if (top.isInteger()) {
//                    // Setting iterator one step back.
//                    stack.peek().previous();
//                    return true;
//                }
//                stack.push(top.getList().listIterator());
//            }
//        }
//        return false;
//    }
//}