package com.forum.Entity;

import java.sql.Date;

public class Question {
	private int question_id;
	private Date upload_date;
	private String upload_title;
	private String upload_question;
	private int uploader;
	public int getQuestion_id() {
		return question_id;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", upload_date=" + upload_date + ", upload_title="
				+ upload_title + ", upload_question=" + upload_question + ", uploader=" + uploader + "]";
	}

	public Question() {
		super();
	}


	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}

	public String getUpload_title() {
		return upload_title;
	}

	public void setUpload_title(String upload_title) {
		this.upload_title = upload_title;
	}

	public String getUpload_question() {
		return upload_question;
	}

	public void setUpload_question(String upload_question) {
		this.upload_question = upload_question;
	}

	public int getUploader() {
		return uploader;
	}

	public void setUploader(int uploader) {
		this.uploader = uploader;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public Question(int question_id, Date upload_date, String upload_title, String upload_question, int uploader) {
		super();
		this.question_id = question_id;
		this.upload_date = upload_date;
		this.upload_title = upload_title;
		this.upload_question = upload_question;
		this.uploader = uploader;
	}

}