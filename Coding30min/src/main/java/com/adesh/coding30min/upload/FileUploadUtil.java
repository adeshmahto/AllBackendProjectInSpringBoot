package com.adesh.coding30min.upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.adesh.coding30min.entities.Doc;

public class FileUploadUtil {
	
	public static String saveFile(String fileName,MultipartFile multipartFile) throws IOException {
		
		Path uploadDirectory=Paths.get("Files-Upload");//folder name where file suppose store
		
		String fileCode= RandomStringUtils.randomAlphanumeric(8);
		
		try (InputStream inputStream =multipartFile.getInputStream()){
			
			Path filePath=uploadDirectory.resolve(fileCode+"-"+fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
			
			
			
		}catch(IOException ioe) {
			throw new IOException("Error saving uploaded file"+fileName, ioe);
			
		}
		return fileCode;
		/*
		Doc doc = null;
		String []fileArray1 = fileName.split("\\");
		String[] fileArray2 = null;
		if(fileArray1.length == 0) fileArray2 = new String[] {"myfile"};
		else fileArray2 = fileArray1[fileArray1.length - 1].split(".");
		if(fileArray2.length == 0) doc = new Doc("myfile", "pdf", Files.readAllBytes(Paths.get(multipartFile.getOriginalFilename())));
		if(fileArray2.length == 1) doc = new Doc(fileArray2[fileArray2.length - 1], fileArray2[fileArray2.length - 1], Files.readAllBytes(Paths.get(multipartFile.getOriginalFilename())));
		else doc = new Doc(fileArray2[fileArray2.length - 2], fileArray2[fileArray2.length - 1], Files.readAllBytes(Paths.get(multipartFile.getOriginalFilename())));
		return doc.getId().toString();
		*/
		/*
		Doc doc = new Doc(fileName, "pdf", multipartFile.getBytes());
		return RandomStringUtils.randomAlphanumeric(8);
		*/
	}

}