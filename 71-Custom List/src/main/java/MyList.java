import java.util.Arrays;

public class MyList<T> {

    private T[] array;
    private int startIndex = 10;

    public MyList() {
        array = (T[]) new Object[startIndex];
    }

    public MyList(int startIndex) {
        this.startIndex = startIndex;
        array = (T[]) new Object[startIndex];
    }

    public MyList(T[] arr) {
        array = arr;
    }

    public boolean isEmpty() {
        if (Arrays.stream(array)
                .allMatch(element -> (element == null)))
            return true;
        else return false;
    }

    public int size() {
        return Arrays.stream(array)
                .filter(element -> (element != null))
                .toList()
                .size();
    }

    public int getCapacity() {
        return array.length;
    }

    public void add(T input) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = input;
                return;
            }
        }

        T[] newArray = (T[]) new Object[array.length + array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        add(input);
    }

    public T get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if (array.length-1 < index
                || array[index] == null)
            return;

        T value = array[index];
        for (int i = index+1; i < array.length; i++)
            if (array[i] != null)
                array[i-1] = array[i];
            else {
                array[i-1] = null;
                break;
            }

    }

    public void set(int index, T value) {
        if (array.length-1 < index
                || array[index] == null)
            return;

        array[index] = value;
    }

    public String toString() {
        return Arrays.stream(array).filter(element -> (element != null)).toList().toString();
    }

    public int indexOf(T input) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == input) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(T input) {
        int index = -1;
        for (int i = size()-1; i >= 0; i--) {
            if (array[i] == input) {
                index = i;
                break;
            }
        }
        return index;
    }

    public T[] toArray() {
        return array.clone();
    }

    public T[] clone() {
        return array.clone();
    }

    public void clear() {
        array = (T[]) new Object[startIndex];
    }

    public MyList<T> subList(int begin, int finish) {
        if ((begin > array.length-1 || array[begin] == null)
                && (finish > array.length-1 || array[finish] == null)
                && (begin < 0 && finish < 0))
            return null;

        T[] newArray = (T[]) new Object[array.length];
        System.arraycopy(array, begin, newArray, 0, (finish+1-begin));
        return new MyList<T>(newArray);
    }

    public boolean contains(T data) {
        return Arrays.stream(array).anyMatch(element -> (element == data));
    }

}
