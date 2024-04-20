import java.util.Iterator;

public class MyMinHeap<T extends Comparable<T>>{
    private MyArrayList<T> heapList;

    public MyMinHeap() {
        heapList = new MyArrayList<T>() {
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

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heapList.get(index).compareTo(heapList.get(parentIndex)) < 0) {
            heapList.set(index, heapList.get(parentIndex));
            heapList.set(parentIndex, heapList.get(index));
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public boolean isEmpty() {
        return heapList.isEmpty();
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heapList.size() && heapList.get(leftChildIndex).compareTo(heapList.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heapList.size() && heapList.get(rightChildIndex).compareTo(heapList.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            T temp = heapList.get(index);
            heapList.set(index, heapList.get(smallest));
            heapList.set(smallest, temp);
            heapifyDown(smallest);
        }
    }
    public void insert(T item){
        heapList.add(item);
        heapifyUp(heapList.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heapList.get(0);
        heapList.removeLast();
        if (!isEmpty()) {
            heapList.set(0, heapList.getLast());
            heapifyDown(0);
        }
        return min;
    }

}
