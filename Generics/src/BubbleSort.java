import java.util.Comparator;

public class BubbleSort {


    public static <T> void sort(T[] array, Comparator<T> comparator) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare(array[i], array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i);
                    isSorted = false;
                }
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] array, int i) {
        T temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
    }
}
