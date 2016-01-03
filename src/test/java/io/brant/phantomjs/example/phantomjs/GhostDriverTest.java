package io.brant.phantomjs.example.phantomjs;

import io.brant.phantomjs.example.ApplicationInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationInitializer.class)
public class GhostDriverTest {

	@Autowired
	private GhostDriver ghostDriver;

	@Test
	public void captureKakaoDotCom() throws IOException {
		BufferedImage capturedImage = ghostDriver.getScreenshotAsBufferedImage("http://www.kakao.com");

		ImageIO.write(capturedImage, "png", new File("/Users/brant/Desktop/kakao.png"));
	}

	@Test
	public void captureCouponImage() throws IOException {
		CaptureConfig captureConfig = new CaptureConfig();
		captureConfig.setWidth(350);
		captureConfig.setHeight(620);

		BufferedImage brant = ghostDriver.getScreenshotAsBufferedImage("http://localhost:8080/coupon?name=Brant&price=10,000&code=brantplate::1000", captureConfig);
		ImageIO.write(brant, "png", new File("/Users/brant/Desktop/brant.png"));

		BufferedImage tiffany = ghostDriver.getScreenshotAsBufferedImage("http://localhost:8080/coupon?name=Tiffany&price=20,000&code=brantplate::1001", captureConfig);
		ImageIO.write(tiffany, "png", new File("/Users/brant/Desktop/tiffany.png"));
	}
}