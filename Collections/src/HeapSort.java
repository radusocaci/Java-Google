import java.util.*;

public class HeapSort {
    private static <E> List<E> heapSort(Collection<E> toSort) {
        Queue<E> priorityQueue = new PriorityQueue<>(toSort);
        List<E> resultList = new ArrayList<>();

        while(!priorityQueue.isEmpty()) {
            resultList.add(priorityQueue.poll());
        }

        return resultList;
    }

    public static void main(String[] args){
        List<Integer> toSort = Arrays.asList(10, 2, 13, 4, 7);

        System.out.print("The initial array: ");
        toSort.stream().forEach((E) -> System.out.print(E + " "));

        System.out.print("\nThe sorted array: ");
        heapSort(toSort).stream().forEach((E) -> System.out.print(E + " "));
    }
}
