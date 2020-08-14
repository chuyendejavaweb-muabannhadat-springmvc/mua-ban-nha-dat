package com.muabannhadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.muabannhadat.entity.FeedbackEntity;
import com.muabannhadat.repository.FeedbackRespository;
import com.muabannhadat.service.FeedbackService;

@Repository("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackRespository feedbackRespository;

	@Override
	public void browseArticles(Long id) {
		FeedbackEntity entity = feedbackRespository.getOne(id);
		if(entity.getStatus().contentEquals("1")) {
			
			entity.setStatus("2");
		}else if(entity.getStatus().contentEquals("2")) {
			entity.setStatus("1");
		}
		feedbackRespository.save(entity);
	}

	@Override
	public Long count() {
		Long id = feedbackRespository.count();
		return id;
	}

	@Override
	public List<FeedbackEntity> findAll() {
		return feedbackRespository.findAll();
	}

}
