import java.util.Iterator;


public abstract class MyArrayList<T>  implements MyList<T>{
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        } else {
            list = (T[]) new Object[capacity];
        }
    }


    public MyArrayList(){
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T item){
        list[size++] = item;
    }

    @Override
    public void set(int index, T item){
        for (int i = size; i > index; i--){
            list[i] = list[i-1];
        }

        list[index] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    @Override

    public void addFirst(T item){
        if (size == list.length) {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(list, 0, newArray, 1, size);
            list = newArray;
        } else {
            System.arraycopy(list, 0, list, 1, size);
        }

        list[0] = item;
        size++;
    }

    @Override
    public void addLast(T item){
        if (size == list.length) {
            T[] newArray = (T[]) new Object[size * 2];
            System.arraycopy(list, 0, newArray, 0, size);
            list = newArray;
        }

        list[size] = item;
        size++;
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return list[index];
    }

    @Override
    public T getFirst(){
        if (size == 0) {
            throw new IllegalArgumentException("List is empty");
        }
        return list[0];
    }

    @Override
    public T getLast(){
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return list[size - 1];
    }


    @Override

    public void remove(int index){
        for(int i = index; i < size; i++){
            list[i] = list[i+1];
        }
    }

    @Override
    public void removeFirst(){
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        System.arraycopy(list, 1, list, 0, size - 1);
        size--;
    }

    @Override
    public void removeLast(){
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        size--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (list[j] != null && list[j + 1] != null && ((Comparable<T>) list[j]).compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }


    @Override
    public int indexOf(Object object) {
        Iterator<T> iterator = iterator();
        if (iterator == null) {
            return -1;
        }

        int index = 0; // Индекс элемента
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (element != null && element.equals(object)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object object){
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object){
        for (T element : list) {
            if (element != null && element.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        System.arraycopy(list, 0, array, 0, size);
        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }


    public void display(){
        for( T item : list){
            System.out.println(item + " ");
        }
    }
}
