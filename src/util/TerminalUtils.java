// File:    TerminalUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-26
// Edited:  2026-11-26

package util;

public final class TerminalUtils {

    private static final String ALT_SCREEN_ON  = "\033[?1049h";
    private static final String ALT_SCREEN_OFF = "\033[?1049l";
    private static final String CLEAR_SCREEN   = "\033[2J\033[H\033[3J";

    private TerminalUtils() {}

    public static void enterAltScreen() {
        System.out.print(ALT_SCREEN_ON + CLEAR_SCREEN);
        System.out.flush();
        Runtime.getRuntime().addShutdownHook(new Thread(TerminalUtils::leaveAltScreen));
    }

    public static void leaveAltScreen() {
        System.out.print(ALT_SCREEN_OFF);
        System.out.flush();
    }

    public static void clear() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

}

// EOF
