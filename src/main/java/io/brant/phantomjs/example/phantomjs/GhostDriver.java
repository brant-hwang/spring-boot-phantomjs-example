package io.brant.phantomjs.example.phantomjs;

import org.openqa.selenium.*;
import org.openqa.selenium.io.IOUtils;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class GhostDriver {

	private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	static {
		desiredCapabilities.setJavascriptEnabled(true);
		desiredCapabilities.setCapability("takesScreenshot", true);
	}

	public byte[] getScreenshotAsBytes(String url, CaptureConfig captureConfig) {
		WebDriver webDriver = new PhantomJSDriver(desiredCapabilities);
		webDriver.get(url);

		if (captureConfig.getX() > 0 || captureConfig.getY() > 0) {
			webDriver.manage().window().setPosition(new Point(captureConfig.getX(), captureConfig.getY()));
		}

		if (captureConfig.getWidth() > 0 && captureConfig.getHeight() > 0) {
			webDriver.manage().window().setSize(new Dimension(captureConfig.getWidth(), captureConfig.getHeight()));
		}

		try {
			String cssFontRule = IOUtils.readFully(new ClassPathResource("/phantomjs/cssFontRule.js").getInputStream());
			((JavascriptExecutor) webDriver).executeScript(cssFontRule);
			Thread.sleep(1000);
		} catch (Exception e) {
			// ignored
		}

		byte[] bytes = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

		webDriver.quit();

		return bytes;
	}

	public BufferedImage getScreenshotAsBufferedImage(String url, CaptureConfig captureConfig) {
		byte[] bytes = getScreenshotAsBytes(url, captureConfig);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

		try {
			return ImageIO.read(byteArrayInputStream);
		} catch (IOException e) {
			// ignored
		}

		return null;
	}

	public BufferedImage getScreenshotAsBufferedImage(String url) {
		return getScreenshotAsBufferedImage(url, CaptureConfig.defaultConfig());
	}
}
