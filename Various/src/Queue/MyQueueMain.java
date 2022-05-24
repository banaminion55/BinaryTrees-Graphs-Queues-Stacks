package Queue;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue<Location> queue = new MyQueue();
        queue.enqueue(new Location(5,3));
        queue.enqueue(new Location(1,-1));
        queue.enqueue(new Location(0,0));
        queue.dequeue();
        Location loc = queue.dequeue();
        System.out.println(loc);
        System.out.println(queue.size());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
        queue.enqueue(new Location(4,0));
        System.out.println(queue.peek());
    }
}
