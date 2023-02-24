//package com.adesh.coding30min.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.adesh.coding30min.entities.Doc;
//import com.adesh.coding30min.services.DocService;
//
//
//@RestController
//public class DocController {
//	
//	@Autowired
//	private DocService docService;
//	
//	// due to thymeleaf
//	@GetMapping("/")
//	public String get(Model model) {
//		List<Doc>docs=this.docService.getFiles();
//		model.addAttribute("docs",docs);
//		return "doc";
//	}
//	@PostMapping("/uploadFiles")
//	public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//		for(MultipartFile file:files) {
//			this.docService.saveFile(file);
//		}
//		return "redirect:/";
//		
//	}
//	@GetMapping("/download/{fileId}")
//	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
//		Doc doc=this.docService.getFiles(fileId).get();
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType(doc.getDocType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\""+doc.getDocName()+"\"")
//				.body(new ByteArrayResource(doc.getData()));
//				
//				
//				
//			
//		
//	}
//
//}
