class StockSpanner {

    Stack<int[]> st =null;

    public StockSpanner() {
        this.st = new Stack<>();
    }
    
    public int next(int price) {

        if(st.isEmpty() || st.peek()[0]>price){
            st.push(new int[]{price,1});
            return 1;
        }
        int count=0;
        while(!st.isEmpty() && st.peek()[0]<=price){
             count +=st.pop()[1];
        }
        st.push(new int[]{price,count+1});
        return count+1;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */