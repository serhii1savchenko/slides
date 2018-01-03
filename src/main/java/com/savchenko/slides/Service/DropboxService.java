package com.savchenko.slides.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox.core.DbxException;
import com.savchenko.slides.DAO.DropboxFilesDAO;
import com.savchenko.slides.Utils.Utils;

@Service
public class DropboxService {
	
	@Autowired
	DropboxFilesDAO dropboxDao;
	
	@Autowired
	Utils util;
	
	public void createFolderAndUploadImages(String folderName, File[] images) throws DbxException, IOException {
		dropboxDao.createFolder("/"+folderName);
		int counter = 0;
		for(File curImg : images) {
			dropboxDao.uploadFile(curImg.getAbsolutePath(), "/"+folderName+"/"+(counter++)+".png");
		}
		for(File curImg : images) {
			//System.out.println(curImg.getAbsolutePath());
            //Path p = Paths.get(curImg.getAbsolutePath());
			//Files.deleteIfExists(p);
			System.out.println(curImg.delete());
		}
	}
	
	public String[] getSlides(String folderName, int numberOfSlides) {
		File[] files = dropboxDao.readFiles(folderName, numberOfSlides);
		String[] images = new String[numberOfSlides];
		for(int i=0; i<numberOfSlides; i++)
			images[i] = util.encodeBase64(files[i]);
		return images;
	}
	
}
