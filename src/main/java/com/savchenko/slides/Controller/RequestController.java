package com.savchenko.slides.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savchenko.slides.Service.DropboxService;
import com.savchenko.slides.Service.PresentationService;

@Controller
public class RequestController {

	@Autowired
	PresentationService presService;

	@Autowired
	DropboxService dropboxService;

	@RequestMapping(value = "/open/{folderName:.+}", method = RequestMethod.GET)
	public String getPresentation(@PathVariable(value="folderName") String folderName, Model model) {
		System.out.println(folderName);
		int numberOfSlides = presService.getNumberOfSlides(folderName);
		if(numberOfSlides == 0) {
			model.addAttribute("msg", "NO SUCH PRESENTATION YET");
			return "errorPageBadFile";
		}else {
			model.addAttribute("numberOfSlides", numberOfSlides);
			model.addAttribute("slidesArray", dropboxService.getSlides(folderName, numberOfSlides));			// slides as Base64 encoded Strings
			return "view";
		}
	}

}
