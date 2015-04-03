package data;

import de.ksquared.system.keyboard.GlobalKeyListener;
import de.ksquared.system.keyboard.KeyAdapter;
import de.ksquared.system.keyboard.KeyEvent;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Kristian on 03/04/2015.
 */
public class Boot {


    public Boot() throws AWTException, IOException {
        Swap s = new Swap();
        Robot r = new Robot();
        GUI g = new GUI();

        g.BeginSession();

        new GlobalKeyListener().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getVirtualKeyCode() == KeyEvent.VK_E) {
                    System.out.println("Swapping");

                    s.MouseLocation();

                    try {
                        s.Nemesis();
                        g.PictureToUpdate();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    r.delay(500);
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }
        });

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws AWTException, IOException {
        new Boot();
    }
}
