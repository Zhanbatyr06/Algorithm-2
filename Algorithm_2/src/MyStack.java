import java.util.Iterator;

public class MyStack<T> {
    private MyArrayList<T> stackList;

    public MyStack() {
        stackList = new MyArrayList<T>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterator<T> iterator() {
                return null;
            }
        };
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public void push(T item) {
        stackList.add(item);
    }

    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
       stackList.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackList.getLast();
    }


}
