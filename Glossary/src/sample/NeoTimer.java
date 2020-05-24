package sample;

import java.util.Timer;

public class NeoTimer extends Timer {
    private static NeoTimer instance;

    private NeoTimer() {

    }
    public static NeoTimer getInstance() {
        if (instance == null) {
            instance = new NeoTimer();
        }
        return instance;
    }

}
