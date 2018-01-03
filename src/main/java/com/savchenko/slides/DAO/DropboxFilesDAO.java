package com.savchenko.slides.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Repository;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.CreateFolderErrorException;
import com.dropbox.core.v2.files.DeleteResult;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

@Repository
public class DropboxFilesDAO {

	private static final String ACCESS_TOKEN = "xxx";
	private DbxRequestConfig config = new DbxRequestConfig("xxx");
	DbxClientV2 client = null;
	FullAccount account = null;

	public DropboxFilesDAO(){																	// Create Dropbox client
		config = new DbxRequestConfig("dropbox/java-tutorial");
		client = new DbxClientV2(config, ACCESS_TOKEN);
		try {
			FullAccount account = client.users().getCurrentAccount();
			System.out.println("DROPBOX CONNECTION OK " + account.getName().getDisplayName());
		}
		catch (DbxException dbxe){
			dbxe.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void createFolder(String folderName) throws DbxException {
		try {
			FolderMetadata folder = client.files().createFolder(folderName);
			System.out.println(folder.getName());
		} catch (CreateFolderErrorException err) {
			if (err.errorValue.isPath() && err.errorValue.getPathValue().isConflict()) {
				System.out.println("Something already exists at the path.");
			} else {
				System.out.print("Some other CreateFolderErrorException occurred...");
				System.out.print(err.toString());
			}
		} catch (Exception err) {
			System.out.print("Some other Exception occurred...");
			System.out.print(err.toString());
		}
	}

	public void listFolder(){
		try{
			// Get files and folder metadata from Dropbox root directory
			ListFolderResult result = client.files().listFolder("");
			while (true) {
				for (Metadata metadata : result.getEntries()) {
					System.out.println(metadata.getPathLower());
				}

				if (!result.getHasMore()) {
					break;
				}

				result = client.files().listFolderContinue(result.getCursor());
			}
		}
		catch (DbxException dbxe){
			dbxe.printStackTrace();
		}         
	}

	public void uploadFile(String path, String foldername){
		try {
			InputStream in = new FileInputStream(path);
			FileMetadata metadata = client.files().uploadBuilder(foldername).uploadAndFinish(in);
			//System.out.println(metadata.toStringMultiline());
			System.out.println("File uploaded!");
		}
		catch (FileNotFoundException fne){
			fne.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		catch (DbxException dbxe){
			dbxe.printStackTrace();
		}
	}

	public void readFile(String foldername, String filename, String pathForDownload){
		try{
			FileOutputStream downloadFile = new FileOutputStream(pathForDownload + filename);
			try {
				FileMetadata metadata = client.files().downloadBuilder(foldername).download(downloadFile);
				//System.out.println(metadata.toStringMultiline());
				System.out.println("File readed ... OK");
			} finally{
				downloadFile.close();
			}
		}
		catch (DbxException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public File[] readFiles(String foldername, int size){
		File[] images = new File[size];

		for(int i=0; i<size; i++){
			try{
				FileOutputStream downloadFile = new FileOutputStream(i+".png");
				try {
					FileMetadata metadata = client.files().downloadBuilder("/"+foldername+"/"+i+".png").download(downloadFile);
					System.out.println("File readed ... OK");
				} finally{
					downloadFile.close();
				}
			}
			catch (DbxException e){
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}
			
			images[i] = new File(i+".png");
		}

		return images;
	}

	public void deleteFile(String path){
		try{
			DeleteResult dr = client.files().deleteV2(path);
			System.out.println(dr.toStringMultiline());
		}
		catch (DbxException dbxe){
			dbxe.printStackTrace();
		}
	}


}
