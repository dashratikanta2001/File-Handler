package com.ratikanta.service;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Header;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {
	
	private Logger logger = LoggerFactory.getLogger(PdfService.class);

	public ByteArrayInputStream createPdf()
	{
		logger.info("Create pdf started : ");
		
		String title = "Welcome Ratikanta";
		
		String content = "Hello Ratikanta.";
		
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		
		Document document = new Document();
		
		PdfWriter.getInstance(document, out);
		
		Header header = new Header(title, content);
//		header.
		
		
		HeaderFooter footer = new HeaderFooter(true, new Phrase(" page"));
		
		HeaderFooter footer2 = new HeaderFooter(new Phrase("page: "), true);
        footer2.setAlignment(Element.ALIGN_CENTER);
        footer2.setBorderWidthBottom(0);
        footer2.setBorderColor(new Color(255, 0, 0));
        document.setFooter(footer2);
        
        
		
		document.open();
		
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		
		Paragraph titlePara = new Paragraph(title,titleFont);
		
		titlePara.setAlignment(Element.ALIGN_CENTER);
		
		document.add(titlePara);
		
		
		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA,18);
		Paragraph paragraph = new Paragraph(content);
		
		paragraph.add(new Chunk("WOW this text is added after creating paragraph"));
		
		document.add(paragraph);
		
		document.close();
	
		
		
		
		return new ByteArrayInputStream(out.toByteArray());
		
		
		
		
	}
	
}

























