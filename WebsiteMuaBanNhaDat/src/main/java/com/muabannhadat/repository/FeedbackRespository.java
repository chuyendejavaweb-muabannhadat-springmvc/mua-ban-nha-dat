package com.muabannhadat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.muabannhadat.entity.FeedbackEntity;

@Repository("feedbackRespository")
public interface FeedbackRespository extends JpaRepository<FeedbackEntity, Long> {
	@Query("SELECT count(*) numberfeedback FROM feedback f inner join users u inner join postnew p on f.id= u.id and p.id= f.id")
	long count();

	@Query("SELECT f.id as maphanhoi,p.id as mabaidang,p.title,f.time as thoigianphanhoi ,"
			+ "p.start_day,u.fullname,ft.name,p.status FROM feedback f inner join postnew p "
			+ "inner join users u inner join feedbacktype ft on f.id= u.id and p.id= f.id"
			+ " and ft.id = f.id")
	List<FeedbackEntity> findAll();

}
