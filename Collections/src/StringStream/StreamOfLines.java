package StringStream;

// Fig. 17.17: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLines
{
   public static void main(String[] args) throws IOException
   {
      // Regex that matches one or more consecutive whitespace characters
      Pattern pattern = Pattern.compile("\\s+"); // one or more consecutive whitespaces

      // count occurrences of each word in a Stream<String> sorted by word
      Map<String, Long> wordCounts = 
         Files.lines(Paths.get("C:\\Users\\Radu\\Desktop\\Java-Google\\Collections\\src\\StringStream\\", "Chapter2Paragraph.txt")) // read all lines from a file as a Stream
              .map(line -> line.replaceAll("(?!')\\p{P}", "")) // (?!') - ignore apostrophes   \p{P} - matches any punctuation character
              .flatMap(line -> pattern.splitAsStream(line)) // converts the stream of lines into a stream of words based on pattern
              .collect(Collectors.groupingBy(String::toLowerCase, // generates a treemap for sorted order
                 TreeMap::new, Collectors.counting()));
      
      // display the words grouped by starting letter
      wordCounts.entrySet()
         .stream()
         .collect(
            Collectors.groupingBy(entry -> entry.getKey().charAt(0), 
               TreeMap::new, Collectors.toList()))
         .forEach((letter, wordList) -> 
            { 
               System.out.printf("%n%C%n", letter);
               wordList.stream().forEach(word -> System.out.printf(
                  "%13s: %d%n", word.getKey(), word.getValue()));
            });
   }
} // end class StreamOfLines

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
