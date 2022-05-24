package Queue;

public class MyQueue<T> {

    private MyListNodeObject<T> front = null;
    private MyListNodeObject<T> end = null;

    public synchronized void enqueue(T data) {
        MyListNodeObject<T> temp = new MyListNodeObject<T>(data,null);
        if(front == null) {
            front = temp;
            end = temp;
        }
        else {
            end.setNext(temp);
            end = temp;
        }
    }

    public T dequeue() {
        if(front == null)
            return null;
        MyListNodeObject<T> temp = front;
        front = front.getNext();
        T result = temp.getData();
        temp = null;
        return result;
    } //detached link??? data leak???

    public int size() {
        MyListNodeObject<T> currentNode = front;
        int count = 0;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() {
        if(front != null)
            return front.getData();
        return null;
    }

}
