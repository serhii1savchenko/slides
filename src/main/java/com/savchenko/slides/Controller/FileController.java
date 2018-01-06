package com.savchenko.slides.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.savchenko.slides.Service.PresentationService;

@Controller
public class FileController {

	@Autowired
	ServletContext context;
	
	@Autowired
	PresentationService presServ;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {

		String name = null;
		System.out.println(file.getContentType().toString());
		
		if ((file!=null) && !file.isEmpty() && (file.getContentType().toString().equals("application/vnd.openxmlformats-officedocument.presentationml.presentation") || file.getContentType().toString().equals("application/vnd.ms-powerpoint"))) {
			try {
				byte[] bytes = file.getBytes();
				
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
				int randomNum = ThreadLocalRandom.current().nextInt(100, 1000);
				
				//name = file.getOriginalFilename().replaceAll(" ", "_");
				name = "_"+(dateFormat.format(date)).replaceAll(" ", "_")+"_"+randomNum;
				
				String rootPath = context.getRealPath("/");
				
				File dir = new File(rootPath + File.separator + "loadedFiles");

				if (!dir.exists()) {
					dir.mkdirs();
				}
				
				String filePath = dir.getAbsolutePath() + File.separator + name;
				File uploadedFile = new File(filePath);
				
				System.out.println(uploadedFile.getAbsolutePath());
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
				stream.write(bytes);
				stream.flush();
				stream.close();
				
				presServ.uploadNewPresentation(uploadedFile, name);
				
				Path path = Paths.get(filePath);
				Files.deleteIfExists(path);
				
				model.addAttribute("id", name);
				return "result";

			} catch (Exception e) {
				model.addAttribute("msg", "Something went wrong...");
				return "errorPageBadFile";
			}
		} else {
			model.addAttribute("msg", "Document is empty or it isn't a .PPTX / .PPS MS OFFICE presentation...");
			return "errorPageBadFile";
		}
	}

}
