

import com.dropbox.core.DbxException;
import com.savchenko.slides.DAO.DropboxFilesDAO;

public class Test {
	
	//@Autowired
	static DropboxFilesDAO dfdao = new DropboxFilesDAO();
	
	public static void main(String[] args) throws DbxException {
		
		String folderName = "/test_java_createfolder";
		dfdao.listFolder();
		dfdao.createFolder(folderName);
		dfdao.uploadFile("D:/RRRRR.docx", folderName + "/RRRRR.docx");  
		dfdao.readFile(folderName + "/RRRRR.docx", "_READED_RRRRR.docx", "D:/");
		dfdao.deleteFile(folderName+"/RRRRR.docx");

	}

}
