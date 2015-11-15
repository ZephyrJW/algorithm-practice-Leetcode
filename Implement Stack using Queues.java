// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).


class MyStack {
    Queue<Integer> queue = new LinkedList<>(); // !it's LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        return;
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList<>();
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(queue.isEmpty()) break;
            else{
                temp.add(i);
            }
        }
        
        while(!temp.isEmpty()){
            queue.add(temp.poll());
        }
        return;
    }

    // Get the top element.
    public int top() {
        int size = queue.size();
        Queue<Integer> temp = new LinkedList<>();
        while(size != 1){
            temp.add(queue.poll());
            size--;
        }
        int i = queue.poll();
        temp.add(i);
        
        while(!temp.isEmpty()){
            queue.add(temp.poll());
        }
        return i;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

//little optimization, using only one queue by @ leo_aly7
class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for(int i = 1; i < size; i++)
            q.add(q.remove());
        q.remove();
    }

    // Get the top element.
    public int top() {
        int size = q.size();
        for(int i = 1; i < size; i++)
            q.add(q.remove());
        int ret = q.remove();
        q.add(ret);
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();        
    }
}
