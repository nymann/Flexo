package data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Kristian on 02/04/2015.
 */
public class Swap {

    int x;
    int y;

    public void Nemesis() throws AWTException, IOException {

        Robot bender = new Robot();

        int xCoord = 1630 + (int) Math.random()*5;
        int yCoord = 555 + (int) Math.random()*5;

        bender.keyPress(KeyEvent.VK_I);
        delayFunction(20);
        bender.keyRelease(KeyEvent.VK_I);
        delayFunction(20);

        bender.mouseMove(xCoord, yCoord);
        delayFunction(20);

        bender.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        delayFunction(20);
        bender.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        delayFunction(20);
        ScreenShot();
        delayFunction(50);

        bender.keyPress(KeyEvent.VK_ESCAPE);
        delayFunction(20);
        bender.keyRelease(KeyEvent.VK_ESCAPE);
        delayFunction(20);

        bender.mouseMove(x + (int) Math.random()*5, y + (int) Math.random()*5);
        delayFunction(5);
    }

    public void delayFunction(int msec) throws  AWTException {
        Robot Flexo = new Robot();
        int delaytime = msec + (int) Math.random()*(msec / 4);
        Flexo.delay(delaytime);
    }

    public void MouseLocation() {
        String mouseLocation = MouseInfo.getPointerInfo().getLocation().toString();
        x = Integer.parseInt(mouseLocation.substring(mouseLocation.indexOf("x") + 2, mouseLocation.indexOf(",")));
        y = Integer.parseInt(mouseLocation.substring(mouseLocation.indexOf("y") + 2, mouseLocation.indexOf("]")));
    }

    public void ScreenShot() throws AWTException, IOException {
        Robot r = new Robot();
        GUI g = new GUI();

        BufferedImage bufferedImage = r.createScreenCapture(new Rectangle(1619, 542, 49, 99));
        File imageFile = new File("img/screenshot.png");
        ImageIO.write(bufferedImage, "png", imageFile);
    }

}
