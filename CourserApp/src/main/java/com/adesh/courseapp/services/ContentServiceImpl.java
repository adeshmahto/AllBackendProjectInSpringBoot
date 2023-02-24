package com.adesh.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.courseapp.dao.ContentDao;
import com.adesh.courseapp.entities.Content;
import com.adesh.courseapp.exception.ResourceNotFoundException;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContentDao contentDao;

	@Override
	public Content creatContent(Content content) {
		contentDao.save(content);
		return content;
	    
	}

	@Override
	public List<Content> getAllContent() {
		
		return this.contentDao.findAll();
	}

	@Override
	public Content getSingleContent(Integer contentId) {
		Content content=this.contentDao.findById(contentId).orElseThrow(()->new ResourceNotFoundException("Content","Id",contentId));
		return content;
		
	}

	@Override
	public void deleteContent(Integer contentId) {
		Content entity=this.contentDao.getOne(contentId);
		this.contentDao.delete(entity);
		
	}

	@Override
	public Content updateContent(Content content, Integer contentId) {
		Content entity=this.contentDao.getOne(contentId);
		entity.setDescription(content.getDescription());
		entity.setTitle(content.getTitle());
		entity.setImageName(content.getImageName());
	  Content newEntity=this.contentDao.save(entity);
		return newEntity;
	}

}
