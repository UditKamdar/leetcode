class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        int val = stack.pop();
        if (!minStack.isEmpty() && val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }
}
