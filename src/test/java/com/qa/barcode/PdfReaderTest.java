package com.qa.barcode;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.Base;

public class PdfReaderTest extends Base{

	Base baseObj;
	URL urlObj;
	InputStream isObj;
	BufferedInputStream bisObj;
	PDDocument pdDocObj;
	PDFTextStripper PDFTextStripperObj;
	
	public PdfReaderTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws IOException {
		baseObj=new Base();
		initialization();
	}
	
	@Test
	public void pdfReaderTest() throws IOException { 
		String url2=prop.getProperty("url2");
		urlObj=new URL(url2);
		isObj=urlObj.openStream(); //this will open the stream with this pdf.
		bisObj=new BufferedInputStream(isObj); 
		pdDocObj=PDDocument.load(bisObj);  //load buffered input stream into pdf doc
		PDFTextStripperObj=new PDFTextStripper();
		String pdfContent=PDFTextStripperObj.getText(pdDocObj);
		System.out.println(pdfContent);
		
	}
}
