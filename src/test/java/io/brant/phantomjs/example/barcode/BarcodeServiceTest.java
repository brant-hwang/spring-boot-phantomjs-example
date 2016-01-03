package io.brant.phantomjs.example.barcode;

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
public class BarcodeServiceTest {

	@Autowired
	private BarcodeService barcodeService;

	@Test
	public void barcodeTest() throws IOException {
		BufferedImage barcode = barcodeService.barcode("brantplate::5234");

		ImageIO.write(barcode, "png", new File("/Users/brant/Desktop/barcode.png"));
	}

	@Test
	public void qrCodeTest() throws IOException, InterruptedException {
		BufferedImage barcode = barcodeService.qrCode("brantplate::5234");

		ImageIO.write(barcode, "png", new File("/Users/brant/Desktop/qrcode.png"));
	}
}