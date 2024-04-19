public class LinearQueue {
    private int maxSize; 
    private int[] queueArray; 
    private int front; 
    private int rear; 
    private int currentSize;

    // Constructor to initialize the queue
    public LinearQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Get the number of elements in the queue
    public int size() {
        return currentSize;
    }

    // Insert an element at the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
        System.out.println(data);
    }

    // Remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        System.out.println(data + " dequeued from the queue.");
        return data;
    }

    // Get the front element of the queue without removing it
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queueArray[front];
    }

    // Get the rear element of the queue without removing it
    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queueArray[rear];
    }

    // Print the elements of the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println(queueArray[rear]);
    }

 
    public void clear() {
        front = 0;
        rear = -1;
        currentSize = 0;
        System.out.println("Queue cleared.");
    }
    // Example 
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue(); 

        System.out.println("Front: " + queue.front()); 
        System.out.println("Rear: " + queue.rear()); 

        queue.dequeue();
        queue.printQueue();

        queue.clear();
        System.out.println("Size: " + queue.size()); 
    }
}