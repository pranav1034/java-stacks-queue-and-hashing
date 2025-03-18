import java.util.Stack;

class ImplementQueue {
    private Stack<Integer> s1; // For enqueue
    private Stack<Integer> s2; // For dequeue

    public ImplementQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation (push onto s1)
    public void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Transfer elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop(); // Pop from s2
    }

    // Peek operation (Get front element)
    public int peek() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueue queue = new ImplementQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.peek());    // 2
        System.out.println(queue.dequeue()); // 2
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.isEmpty()); // true
    }
}
