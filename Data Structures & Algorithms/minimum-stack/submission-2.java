class MinStack {

    Stack<int[]> stack;

    int min;

    public MinStack() {
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<min){
            min=val;
        }
        stack.push(new int[]{val,min});
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
        if(!stack.isEmpty()){
            min=stack.peek()[1];
        }else{
            min=Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.isEmpty()?null:stack.peek()[0];
    }
    
    public int getMin() {
        return min;
    }
}
