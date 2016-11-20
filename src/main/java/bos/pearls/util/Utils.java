package bos.pearls.util;

public class Utils {
    private Utils() {}

    public static <T> T checkNotNull(T object) {
        if(object == null) {
            throw new NullPointerException();
        }

        return object;
    }
}
