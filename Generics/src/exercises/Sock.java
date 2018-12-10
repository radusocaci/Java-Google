package exercises;

public class Sock {
    int number;
    String color;

    public Sock(int number, String color) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Sock{" +
                "number=" + number +
                ", color='" + color + '\'' +
                '}';
    }
}
