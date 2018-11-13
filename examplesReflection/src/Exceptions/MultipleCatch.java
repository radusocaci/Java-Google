package Exceptions;

import java.io.IOException;

public class MultipleCatch {
    public static void main(String[] args) {
        try {
            ageInMonths(Integer.parseInt("-1"));
        } catch (NumberFormatException e) {
            System.out.println("first program argument needs to be an int");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } /*catch (IOException ex){ //what about OutOfMemoryException ex or???

        }*/

    }

    static int ageInMonths(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("age should be >= 0");
        }
        return age * 12;
    }
}
