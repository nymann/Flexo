package data;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Kristian on 02/04/2015.
 */
public class GUI extends JFrame {
    public GUI() {
    }
    JPanel P = new JPanel();
    JLabel L = new JLabel();

    public void BeginSession() throws IOException {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setLocation(0, 700);
        setVisible(true);
        setSize(60, 110);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        P.add(L);
        add(P);
        validate();
        setBackground(new Color(0, 0, 0, 0));
        P.setBackground(new Color(0, 0, 0, 0));
    }

    public void PictureToUpdate() throws IOException {
        BufferedImage buffImg = ImageIO.read(new File("img/screenshot.png"));
        L.setIcon(new ImageIcon(buffImg));
        revalidate();
    }
}
