package com.adesh.courseapp.services;

import java.util.List;

import com.adesh.courseapp.entities.Content;

public interface ContentService {
	
	public Content creatContent(Content content);

	public List<Content> getAllContent();
	
	public Content getSingleContent(Integer contentId);
	
	public Content updateContent(Content content, Integer contentId);
	
	void deleteContent(Integer contentId);
	
	
		
	
}
