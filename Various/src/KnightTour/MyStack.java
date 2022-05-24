package KnightTour;

public class MyStack<T> {

    private MyListNodeObject<T> top = null;

    public void push(T data) {
        if(top == null)
            top = new MyListNodeObject<T>(data,null);
        else {
            top = new MyListNodeObject<T>(data, top);
        }
    }

    public int size() {
        MyListNodeObject<T> currentNode = top;
        int count = 0;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public T pop() {
        if(top == null)
            return null;
        MyListNodeObject<T> temp = top;
        top = top.getNext();
        T data = temp.getData();
        temp = null;
        return data;
    }

    public T peek() {
        if(top == null)
            return null;
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

}
