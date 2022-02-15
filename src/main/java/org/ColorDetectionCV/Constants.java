package org.ColorDetectionCV;

import org.opencv.core.Scalar;

public class Constants {
    // Camera used for detection
    public static final int CAMERA_INDEX = 0;

    // Color options for detection
    public static final String[] COLOR_OPTIONS = {"BLUE", "RED"};

    /* BGR upper and lower color bounds */
    // Red
    public static final Scalar RED_LOWER_BOUND = new Scalar(0, 0, 100);
    public static final Scalar RED_UPPER_BOUND = new Scalar(70, 70, 255);

    // Blue
    public static final Scalar BLUE_LOWER_BOUND = new Scalar(90, 0, 0);
    public static final Scalar BLUE_UPPER_BOUND = new Scalar(255, 85, 85);
}
