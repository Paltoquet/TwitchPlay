import org.pircbotx.PircBotX;

import java.util.Scanner;

/**
 * Created by thibault on 17/10/2015.
 */
public class InputThread extends Thread {
    boolean running = true;
    boolean echo = true;
    MonListener a;

    public InputThread(MonListener b) {
        a = b;
    }

    @Override
    public void run() {
        while (running) {
            String input;
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            if (str != null) {
                a.notifie();
            }
        }
    }
}