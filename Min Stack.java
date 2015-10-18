// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.

class MinStack {
    class Node{
        int val;
        Node next;
        int min;
        
        Node(int x, int min){
            this.val = x;
            this.min = min;
            next = null;
        }
    }
    
    Node head;
    public void push(int x) {
        if(head == null){
            head = new Node(x,x);
        }else{
            Node n = new Node(x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        if(head != null) head = head.next;
    }

    public int top() {
        if(head != null) return head.val;
        else return -1;
    }

    public int getMin() {
        if(head != null) return head.min;
        else return -1;
    }
}
