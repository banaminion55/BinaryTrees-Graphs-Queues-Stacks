package KnightTour;

public class MyListNodeObject<T> {

    private T data;
    private MyListNodeObject<T> next;

    public MyListNodeObject(T data, MyListNodeObject<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyListNodeObject<T> getNext() {
        return next;
    }

    public void setNext(MyListNodeObject<T> next) {
        this.next = next;
    }

}

