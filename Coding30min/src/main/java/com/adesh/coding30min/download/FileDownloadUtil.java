package com.adesh.coding30min.download;

import com.adesh.coding30min.config.URLClassLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FileDownloadUtil {
	
	private URLClassLoader urlClassLoader;
	
	private Path foundFile;
	
	public Resource getFileAsResource(String fileCode) throws IOException {
		
		//changing to pdf
		URLClassLoader.pdfToWord(fileCode);
		
		Path uploadDirectory=Paths.get("Files-Upload"); //resouce will download here
		
		Files.list(uploadDirectory).forEach(file->{
			if(file.getFileName().toString().startsWith(fileCode)) {
				foundFile=file;
				return;
			}
		});
		if(foundFile!=null) {
			System.out.print(foundFile.toString());
			return new UrlResource(foundFile.toUri());
		}
		return null;
		
	}

}
