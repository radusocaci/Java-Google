import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>(Arrays.asList("RED", "GREEN", "BLUE"));
        System.out.println(list.toString());

        removeColors(list);
        System.out.println("After removal: " + list.toString());
    }

    /**
     * Removes the color RED from the given collection
     * @param stringCollection the ArrayList from which we remove
     */
    static void removeColors(@NotNull ArrayList<String> stringCollection) {
        for(int i = 0; i < stringCollection.size(); i++) {
            if(stringCollection.get(i) == "RED") {
                stringCollection.remove(i);
            }
        }
    }
}
