package org.ColorDetectionCV;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class CameraCapture {
    final static VideoCapture capture = new VideoCapture(Constants.CAMERA_INDEX);

    public static Mat grabFrame() {
        /* Grabs a single frame from the camera feed */

        Mat frame = new Mat();
        capture.read(frame);

        return frame;
    }
}
