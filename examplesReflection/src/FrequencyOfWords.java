import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrequencyOfWords {

    private static void countWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));

        while (in.hasNext()) {
            String word = in.next();
            Integer count = words.get(word);

            if (count != null) {
                count++;
            } else {
                count = 1;
            }

            words.put(word, count);
        }

        in.close();
    }

    public static void main(String[] args) {
        Map<String, Integer> wordFreq = new HashMap<>();

        try {
            countWords("Input.txt", wordFreq);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        wordFreq.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10).
                forEach(System.out::println);
    }

}
