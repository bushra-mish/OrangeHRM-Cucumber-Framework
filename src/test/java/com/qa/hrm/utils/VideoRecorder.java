package com.qa.hrm.utils;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/**
 * Wraps Monte Screen Recorder to capture test execution as .avi video files.
 * Call {@link #start(String)} before a scenario and {@link #stop()} after.
 */
public class VideoRecorder {

	private static ScreenRecorder recorder;

	public static void start(String testName) {
		try {
			File dir = new File(System.getProperty("user.dir") + "/target/videos/");
			if (!dir.exists()) dir.mkdirs();

			GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice().getDefaultConfiguration();

			recorder = new ScreenRecorder(gc,
					new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()),
					new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							DepthKey, 24, FrameRateKey, Rational.valueOf(15),
							QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(15)),
					null, dir);
			recorder.start();
			System.out.println("[Video] Recording started: " + testName);
		} catch (IOException | AWTException e) {
			System.err.println("[Video] Failed to start: " + e.getMessage());
		}
	}

	public static void stop() {
		try {
			if (recorder != null) { recorder.stop(); System.out.println("[Video] Recording saved."); }
		} catch (IOException e) { System.err.println("[Video] Failed to stop: " + e.getMessage()); }
	}

}
