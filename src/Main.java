import number.MathUtils;

public class Main {
    private static final long NUMBER = 2;
    public static void main(String[] args) {
        MathUtils.class.getClasses();

        long rustStart = System.nanoTime();
        boolean rustCheck = MathUtils.isPrime(NUMBER);
        long rustEnd = System.nanoTime();

        long javaStart = System.nanoTime();
        boolean javaCheck = isPrime(NUMBER);
        long javaStop = System.nanoTime();

        System.out.println("Rust Check: " + rustCheck);
        System.out.println("Java Check: " + javaCheck);

        System.out.printf("Rust Time: %,d%n", rustEnd - rustStart);
        System.out.printf("Java Time: %,d%n", javaStop - javaStart);
    }

    public static boolean isPrime(long n) {
        if(n % 2 == 0 || n % 3 == 0)
            return n == 2 || n == 3;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return n != 1;
    }
}
