class MinStack {

    Stack<Integer> stack;

    Stack<Integer> minStack;



    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    //  -2 , 0 , 2 ,  1,  3  -3  4  -2
    // min -3.  -2 -3
    
    public void push(int val) {
        if (stack.isEmpty()) {
           minStack.push(val);
        } else {
            if (minStack.peek() >= val) {
                 minStack.push(val);
            }
        }
        stack.push(val);

    }
    
    public void pop() {
        int num = stack.pop();
        if (minStack.peek() == num ) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
