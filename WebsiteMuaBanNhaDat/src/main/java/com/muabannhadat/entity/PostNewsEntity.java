package com.muabannhadat.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "POSTNEW")
public class PostNewsEntity {
//	post_news(id,title,date_submitted,expiration_date,messager_type,id_package,id_post_detail,status).

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PackageTypeEntity type_id;

	private Date start_day;

	private Date end_day;

	@ManyToOne
	@JoinColumn(name = "news_id")
	private NewsTypeEntity news_id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private PostDetailEntity detail;

	private String status;

	@OneToMany(mappedBy = "post_id")
	private List<NewsPostedEntity> posted;

	@OneToMany(mappedBy = "post_id")
	private List<CommentEntity> comment;

	@OneToMany(mappedBy = "post_id")
	private List<FeedbackEntity> feedback;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private UsersEntity user_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PackageTypeEntity getType_id() {
		return type_id;
	}

	public void setType_id(PackageTypeEntity type_id) {
		this.type_id = type_id;
	}

	public Date getStart_day() {
		return start_day;
	}

	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}

	public Date getEnd_day() {
		return end_day;
	}

	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}

	public PostDetailEntity getDetail() {
		return detail;
	}

	public void setDetail(PostDetailEntity detail) {
		this.detail = detail;
	}

	public NewsTypeEntity getNews_id() {
		return news_id;
	}

	public void setNews_id(NewsTypeEntity news_id) {
		this.news_id = news_id;
	}

	public PostDetailEntity getdetail() {
		return detail;
	}

	public void setdetail(PostDetailEntity id_post_detail) {
		this.detail = id_post_detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CommentEntity> getComment() {
		return comment;
	}

	public void setComment(List<CommentEntity> comment) {
		this.comment = comment;
	}

	public List<FeedbackEntity> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<FeedbackEntity> feedback) {
		this.feedback = feedback;
	}

	public UsersEntity getUser_id() {
		return user_id;
	}

	public void setUser_id(UsersEntity user_id) {
		this.user_id = user_id;
	}

}
