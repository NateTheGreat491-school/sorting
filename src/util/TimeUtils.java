// File:    TimeUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package util;

import java.util.Objects;

public final class TimeUtils {

    public record TimedResult<T>(T value, long nanos) {}

    private TimeUtils() {}

    public static long getExecTime(Runnable task) {
        Objects.requireNonNull(task, "Task must not be null.");
        long start = System.nanoTime();
        task.run();
        return System.nanoTime() - start;
    }

    public static <T> TimedResult<T> measure(java.util.function.Supplier<T> supplier) {
        Objects.requireNonNull(supplier, "Supplier must not be null.");
        long start = System.nanoTime();
        T result = supplier.get();
        return new TimedResult<>(result, System.nanoTime() - start);
    }

    public static String getStrTime(long nanos) {
        if (nanos < 1_000L) return nanos + " ns";
        if (nanos < 1_000_000L) {
            return String.format("%.2f µs", nanos / 1_000.0);
        }
        if (nanos < 1_000_000_000L) {
            return String.format("%.2f ms", nanos / 1_000_000.0);
        }
        return String.format("%.3f s", nanos / 1_000_000_000.0);
    }

}


// EOF
