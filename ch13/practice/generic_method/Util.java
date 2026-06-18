package ch13.practice.generic_method;

public class Util {
    public static <K, V, T> boolean compare(Pair<K, V> p1, Pair<T, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }
}
