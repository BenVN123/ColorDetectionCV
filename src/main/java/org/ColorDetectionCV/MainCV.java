package org.ColorDetectionCV;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import javax.swing.*;
import java.util.Objects;

public class MainCV {
    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException
    {
        // Loads the OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Creates JFrame window
        JPanel cameraFeed = new JPanel();
        JPanel processedFeed = new JPanel();
        AppUI.createJFrame(cameraFeed, processedFeed);

        while(true) {
            // Processes the video frame
            Mat original = CameraCapture.grabFrame();
            Mat processed = ImageProcessing.processFrame(
                    original,
                    Objects.requireNonNull(AppUI.comboBox.getSelectedItem()).toString()
            );

            // Updates the JFrame window with the new frames
            AppUI.drawImage(original, cameraFeed);
            AppUI.drawImage(processed, processedFeed);
        }
    }
}
