import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Generics {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        // intList.add("what"); - compiler does not allow this

        Integer integer = intList.get(0);

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("what");
        //Object o = (Integer)list.get(2);

        Stack stack = new NodeStack();
        stack.add("one");
        stack.add("two");
        stack.add("three");
        System.out.println(stack.get());
        System.out.println(stack.get());
        System.out.println(stack.get());

        GenericNodeStack<String> gstack = new GenericNodeStack<String>();
        gstack.add("One");
        gstack.add("Two");
        System.out.println(gstack.get());
        System.out.println(gstack.get());
        GenericNodeStack<Integer> gstack2 = new GenericNodeStack<Integer>();
        gstack2.add(1);
        gstack2.add(2);
        gstack2.add(3);
        System.out.println(gstack2.get());
        System.out.println(gstack2.get());
        System.out.println(gstack2.get());

        Integer[] intArray = new Integer[]{5, 1, 3, 2};
        BubbleSort.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        String[] strArray = new String[]{"banana", "apple", "lemon"};
        BubbleSort.sort(strArray);
        System.out.println(Arrays.toString(strArray));

        Person[] persons = new Person[]{new Person("John", 10), new Person("Lisa", 2)};
        /*BubbleSort.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });*/
        BubbleSort.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(Arrays.toString(persons));
    }

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
