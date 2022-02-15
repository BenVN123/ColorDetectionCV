package org.ColorDetectionCV;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Core;

public class ImageProcessing {
    public static Mat processFrame(Mat frame, String color)
            throws NoSuchFieldException, IllegalAccessException
    {
        /* Uses the inRange method to filter out unwanted colors */

        Mat processed = new Mat();
        Scalar scalar = new Scalar(0, 0, 0);

        Scalar lower_bound = (Scalar) Constants.class
                .getField(color.concat("_LOWER_BOUND")).get(scalar);
        Scalar upper_bound = (Scalar) Constants.class
                .getField(color.concat("_UPPER_BOUND")).get(scalar);
        Core.inRange(frame, lower_bound, upper_bound, processed);

        return processed;
    }
}
