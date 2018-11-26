import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Mihai", 10);
        Person p2 = new Person("Ema", 15);
        Person p3 = new Person("Radu", 18);
        Person p4 = new Person("Radu", 18);

        List<Person> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        for(Person i : list) {
            System.out.println(i);
        }

//        Iterator<Person> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            Person item = iterator.next();
//            if(item.equals("Mihai")) {
//                iterator.remove();
//            }
//            System.out.println(item);
//        }

        // if person cannot implement compareTo, use comparator and put it in treeset constructor
        Set<Person> setList = new TreeSet<>();

        setList.add(p1);
        setList.add(p2);
        setList.add(p3);
        setList.add(p4);

        for(Person i : setList) {
            System.out.println(i);
        }

//        Iterator<String> iterator1 = list.iterator();
//        while(iterator1.hasNext()) {
//            String item = iterator1.next();
//            if(item.equals("Mihai")) {
//                iterator1.remove();
//            }
//            System.out.println(item);
//        }
    }
}
