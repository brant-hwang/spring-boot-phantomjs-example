package io.brant.phantomjs.example;

import io.brant.phantomjs.example.barcode.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CouponRenderController {

	@Autowired
	private BarcodeService barcodeService;

	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
	public String rendering(@RequestParam String name, @RequestParam String price, @RequestParam String code, ModelMap modelMap) throws IOException, InterruptedException {
		modelMap.put("name", name);
		modelMap.put("price", price);
		modelMap.put("barcode", barcodeService.barcodeAsBase64(code));
		modelMap.put("qrCode", barcodeService.qrCodeAsBase64(code));
		return "coupon";
	}
}
