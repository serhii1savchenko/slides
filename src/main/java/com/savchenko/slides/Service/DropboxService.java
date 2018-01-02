package com.savchenko.slides.Service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropbox.core.DbxException;
import com.savchenko.slides.DAO.DropboxFilesDAO;

@Service
public class DropboxService {
	
	@Autowired
	DropboxFilesDAO dropboxDao;
	
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
	
}
