package com.adesh.coding30min.download;

import java.io.IOException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileDownloadController {
	
	@GetMapping("/downloadFile/{fileCode}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode){
		FileDownloadUtil downloadUtil=new FileDownloadUtil();
		Resource resource=null;
		
		try {
		 resource=downloadUtil.getFileAsResource(fileCode);
		}catch(IOException e) {
			return ResponseEntity.internalServerError().build();
		}
		if (resource==null) {
			return new ResponseEntity<>("File not found",HttpStatus.NOT_FOUND);
		}
		System.out.println(resource+"adesh");
		String contentType ="application/octet-stream";
		String headervalue="attachment; filename=\""+resource.getFilename()+"\"";
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,headervalue)
				.body(resource);
		
	
	}

}
