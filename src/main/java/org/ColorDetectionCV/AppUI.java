package org.ColorDetectionCV;

import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class AppUI {
    public static JComboBox<String> comboBox;

    public static void createJFrame(JPanel cameraFeed, JPanel processedFeed) {
        /* Creates the JFrame window where videos are streamed */

        // Window where video streams are shown
        final JFrame window = new JFrame("Color Detection CV");
        window.setSize(new Dimension(1280, 480));
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(new GridLayout(1, 2));
        window.add(cameraFeed);
        window.add(processedFeed);


        // Window where user controls the color
        final JFrame control = new JFrame("Color Control Panel");
        final JPanel controlPanel = new JPanel();
        control.setSize(new Dimension(200, 200));
        control.setLocationRelativeTo(null);
        control.setResizable(true);
        control.setLayout(new GridLayout(1, 1));
        control.add(controlPanel);

        comboBox = new JComboBox<String>(Constants.COLOR_OPTIONS);
        comboBox.setBounds(0, 0, 75, 50);
        controlPanel.add(comboBox);


        // Shows both windows
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        control.setVisible(true);
        control.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void drawImage(Mat frame, JPanel panel) {
        /* Updates the specified panel with the image */

        BufferedImage buffered = matToBufferedImage(frame);

        Graphics graphics = panel.getGraphics();
        graphics.drawImage(buffered, 0, 0, panel);
    }

    public static BufferedImage matToBufferedImage(Mat frame) {
        /* Converts matrix image to buffered image */

        BufferedImage buffered = new BufferedImage(
                frame.width(),
                frame.height(),
                frame.channels() == 1 ? BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_3BYTE_BGR
        );

        byte[] data = ((DataBufferByte) buffered.getRaster().getDataBuffer()).getData();
        frame.get(0, 0, data);

        return buffered;
    }
}
