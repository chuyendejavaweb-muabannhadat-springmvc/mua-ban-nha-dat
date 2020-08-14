package com.muabannhadat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muabannhadat.entity.FeedbackEntity;

@Service
public interface FeedbackService {
	void browseArticles(Long id);
	Long count();
	List<FeedbackEntity> findAll();
}
