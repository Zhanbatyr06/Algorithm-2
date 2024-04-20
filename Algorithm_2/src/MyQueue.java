public class MyQueue<E> {
    private MyLinkedList<E> queueList;

    public MyQueue(){
        queueList = new MyLinkedList<>();
    }

    public void enqueue(E item){
        queueList.addLast(item);
    }

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    public void dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        queueList.removeFirst();
    }

    public E peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return queueList.getFirst();
    }
}
