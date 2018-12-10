package exercises;

public class Glove {
    int number;
    String color;

    public Glove(int number, String color) {
        this.color = color;
        this.number = number;
    }


    @Override
    public String toString() {
        return "Glove{" +
                "number=" + number +
                ", color='" + color + '\'' +
                '}';
    }
}
