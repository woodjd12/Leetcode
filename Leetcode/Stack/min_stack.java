/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
*/

class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> min;
    
    public MinStack() {
        minStack = new Stack<Integer>();
        int minValue = Integer.MAX_VALUE;
        min  = new Stack<Integer>();
        min.push(minValue);
    }
    
    public void push(int val) {
        if (val <= min.peek()) {
            min.push(val);
        }
        minStack.push(val);
    }
    
    public void pop() {
        if (minStack.peek().equals(min.peek())) min.pop();
        minStack.pop();
        
    }
    
    public int top() {
        int top = minStack.peek();
        return top;
    }
    
    public int getMin() {
        return min.peek();
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
