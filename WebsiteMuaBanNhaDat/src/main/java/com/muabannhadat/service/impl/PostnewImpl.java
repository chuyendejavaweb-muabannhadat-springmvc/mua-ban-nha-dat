package com.muabannhadat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.muabannhadat.entity.PostNewsEntity;
import com.muabannhadat.repository.PostnewRespository;
import com.muabannhadat.service.PostnewService;

@Repository("postnewService")
public class PostnewImpl implements PostnewService {

	@Autowired
	private PostnewRespository postnewRespository;

	@Override
	@Transactional
	public void savePostnew(PostNewsEntity postnews) {
		postnewRespository.save(postnews);
	}

	@Override
	@Transactional
	public List<PostNewsEntity> getAll() {
		return postnewRespository.findAll();
	}

	@Override
	public List<PostNewsEntity> getByNewsType(String code) {
		NewsTypeImpl impl = new NewsTypeImpl();
		return impl.getByCode(code).getPost_id();
	}

	@Override
	public void save(PostNewsEntity postNewsEntity) {
		postnewRespository.save(postNewsEntity);
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			postnewRespository.getOne(id);
		}
	}

	@Override
	public void delete(Long id) {
		PostNewsEntity entity = postnewRespository.getOne(id);
		entity.setStatus("2");
		postnewRespository.save(entity);
		
	}

	@Override
	public PostNewsEntity viewDetail(Long id) {
		return postnewRespository.findOne(id);
	}
	@Override
	public void browseArticles(Long id) {
		PostNewsEntity entity = postnewRespository.getOne(id);
		entity.setStatus("1");
		postnewRespository.save(entity);
		
	}

}
