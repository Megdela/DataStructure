public class CircularQueue {
    private int maxSize; // Maximum size of the queue
    private int[] queueArray; // Array to store the elements
    private int front; // Front of the queue
    private int rear; // Rear of the queue
    private int currentSize; // Current number of elements in the queue

    // Constructor to initialize the queue
    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = -1;
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

    // Insert an element at the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = data;
        currentSize++;
        System.out.println(data + " enqueued to the queue.");
    }

    // Remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queueArray[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        currentSize--;
        System.out.println(data + " dequeued from the queue.");
        return data;
    }

    // Clear the queue
    public void clear() {
        front = -1;
        rear = -1;
        currentSize = 0;
        System.out.println("Queue cleared.");
    }

    // Print the elements of the queue
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queueArray[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % maxSize;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue(); // Output: Queue: 10 20 30

        queue.dequeue();
        queue.printQueue(); // Output: Queue: 20 30

        queue.clear();
        System.out.println("Size: " + queue.currentSize); // Output: Size: 0
    }
}