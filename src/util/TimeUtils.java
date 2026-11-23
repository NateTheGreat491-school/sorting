// File:    TimeUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

public final class TimeUtils {

    @FunctionalInterface
    public interface Task {
        void run();
    }

    private TimeUtils() {}

    public static long getExecTime(Task task) {
        if (task == null) throw new IllegalArgumentException("Task must not be null.");

        long start = System.nanoTime();
        task.run();
        return System.nanoTime() - start;
    }

}


// EOF
