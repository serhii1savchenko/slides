package com.savchenko.slides.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox.core.DbxException;
import com.savchenko.slides.DAO.PresentationDAO;

@Service
public class PresentationService {
	
	@Autowired
	ApachePoiPptService apachePOIService;
	
	@Autowired
	DropboxService dropboxService;
	
	@Autowired
	PresentationDAO presentationDao;

	public void uploadAndGetIdForNewPresentation(File presentation, String folderName) throws FileNotFoundException, IOException, DbxException {
		
		int n = apachePOIService.getNumberOfSlides(presentation);
		File[] images = apachePOIService.convertPresentationToImages(presentation);
		
		dropboxService.createFolderAndUploadImages(folderName, images);
		
		presentationDao.insertData(folderName, n);
	}
	
}
