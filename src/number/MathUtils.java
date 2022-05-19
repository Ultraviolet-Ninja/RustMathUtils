package number;

import java.io.File;

public final class MathUtils {
    public static native boolean isPrime(long number);

    static {
        try {
            File f = new File("rust/rust_math/target/debug/rust_math.dll");

            System.load(f.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
