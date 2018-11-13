package Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {
        method1();

    }

    private static void method1() {
        try {
            System.out.println("Beginning of try");
            //  throw new RuntimeException();
            return ;
            // System.out.println("End of try");
        } catch (RuntimeException e) {
            System.out.println("Inside catch");
        } finally {
            System.out.println("Inside finally");
        }
    }

    public static void method2() {
        BufferedReader r = null;
        try {
            r =  new BufferedReader(new FileReader("text.txt"));
            String firstLine = r.readLine();
         //   r.close();
        } catch (IOException e) {
            System.out.println("Cannot read first line from text.txt: “ + e.getMessage()");
        } finally {
            if (r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void method3() {
        try (BufferedReader r = new BufferedReader(new FileReader("text.txt"))) {
            String firstLine = r.readLine();
        } catch (IOException e) {
            System.out.println("Cannot read first line from text.txt: “ + e.getMessage()");
        }
    }

    static double circleArea(double radius) throws Exception {
        if(radius < 0){
            throw new Exception("radius should be positive");
        }
        return Math.PI * radius * radius;
    }

}
