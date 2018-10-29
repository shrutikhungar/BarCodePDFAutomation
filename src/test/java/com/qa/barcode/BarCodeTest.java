package com.qa.barcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.qa.base.Base;

/**
 * Hello world!
 *
 */
public class BarCodeTest extends Base
{
   String url;
   Logger log=Logger.getLogger("com.qa.barcode.BarCodeTest");
   Base baseObj;
   String barCodeUrl;
   
   BarCodeTest() throws IOException{
	   super();
   }
	@BeforeTest
	public void setUp() throws IOException {
		baseObj=new Base();
		baseObj.initialization();
	}
	
	@Test
	public void barCodeTest() throws IOException, NotFoundException, InterruptedException {
		//Entering a text
		driver.findElement(By.xpath("//textarea[contains(@class,\"multi-line\")]")).clear();
		driver.findElement(By.xpath("//textarea[contains(@class,\"multi-line\")]")).sendKeys("This is Shruti");
		driver.findElement(By.xpath("//a[@title = 'Refresh Barcode']")).click();
		Thread.sleep(3000);
		
		barCodeUrl=driver.findElement(By.tagName("img")).getAttribute("src");
		
		URL urlObj=new URL(barCodeUrl);
		
		BufferedImage buffImageObj=ImageIO.read(urlObj);
		
		LuminanceSource buffImageLumSourceObj=new BufferedImageLuminanceSource(buffImageObj); 
		
		BinaryBitmap binBitMapObj=new BinaryBitmap(new HybridBinarizer(buffImageLumSourceObj));
		
		Result result = new MultiFormatReader().decode(binBitMapObj);
		System.out.println(result);
		
	}
}
