import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpliteratorTest {
    public static void main(String[] args){
        List<Integer> intList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());

        Spliterator<Integer> split1 = intList.spliterator();
        System.out.println("split1 size " + split1.getExactSizeIfKnown());

        Spliterator<Integer> split2 = split1.trySplit();
        System.out.println("split1 size " + split1.getExactSizeIfKnown());
        System.out.println("split2 size " + split2.getExactSizeIfKnown());

        split1.forEachRemaining(System.out::println);
        split2.forEachRemaining(System.out::println);
    }
}
