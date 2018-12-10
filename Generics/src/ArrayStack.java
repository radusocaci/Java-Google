public class ArrayStack implements Stack {

    private String[] objects = new String[5];
    private int counter;

    public void add(String obj) {
        objects[counter++] = obj;
    }

    public String get() {
        counter--;
        String val = objects[counter];
        objects[counter] = null;
        return val;
    }

}
