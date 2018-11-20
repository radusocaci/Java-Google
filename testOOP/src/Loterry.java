import java.util.Scanner;
import java.math.BigInteger;

public class Loterry {

    private static BigInteger factorial(int number) {
        BigInteger nr = new BigInteger("1");

        for (int i = 1; i <= number; i++) {
            nr = nr.multiply(new BigInteger(i + ""));
        }

        return nr;
    }

    public static void probability(int howMany, int outOf) {
        BigInteger n = Loterry.factorial(outOf);
        BigInteger down = Loterry.factorial(howMany).multiply(Loterry.factorial(outOf - howMany));

        System.out.println("The chances of winning the lottery (" + howMany + " out of " + outOf + ") is: "
                + (double) 1 / n.divide(down).intValue());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Loterry.probability(in.nextInt(), in.nextInt());

        in.close();
    }
}