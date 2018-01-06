package com.savchenko.slides.Service;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApachePoiPptService {
	
	@Autowired
	ServletContext context;
	
	public int getNumberOfSlides(File presentation) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(presentation));
		return ppt.getSlides().length;
	}

	public File[] convertPresentationToImages(File presentation) throws FileNotFoundException, IOException {
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(presentation));
		Dimension pgsize = ppt.getPageSize();
        XSLFSlide[] slides = ppt.getSlides();
        
        File[] images = new File[ppt.getSlides().length];
        
        for (int i = 0; i < slides.length; i++) {
            BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = img.createGraphics();

            //clear the drawing area
            graphics.setPaint(Color.white);
            graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));

            //render
            Arrays.asList(slides).get(i).draw(graphics);

            //creating an image file as output
            String path = context.getRealPath("/") + "ppt_image_" + i + ".png";
            FileOutputStream out = new FileOutputStream(path);
            javax.imageio.ImageIO.write(img, "png", out);
            System.out.println("Image successfully created");
            out.close();
            images[i] = new File(path);
        }
		return images;
	}
	
}
