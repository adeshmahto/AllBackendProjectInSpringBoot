package com.adesh.coding30min.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adesh.coding30min.entities.Doc;
import com.adesh.coding30min.repositories.DocRepository;

@Service
public class DocService {
	
	@Autowired
	private DocRepository docRepository;
	
	public Doc saveFile(MultipartFile file) {
		String docname=file.getOriginalFilename();
		
		try {
			Doc doc=new Doc(docname,file.getContentType(),file.getBytes());
			return this.docRepository.save(doc);

		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public Optional<Doc>getFiles(Integer fileId){
		return docRepository.findById(fileId);
	}
	public List<Doc> getFiles(){
		return docRepository.findAll();
		
	}

}
