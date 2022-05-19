package com.forum.Entity;

public class ReplyDetail {
	private Reply rep;
	private Question que;
	private User user;

	public Reply getRep() {
		return rep;
	}

	public void setRep(Reply rep) {
		this.rep = rep;
	}

	public Question getQue() {
		return que;
	}

	public void setQue(Question que) {
		this.que = que;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ReplyDetail() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String toString() {
		return "ReplyDetail [rep=" + rep + ", que=" + que + ", user=" + user + "]";
	}

	public ReplyDetail(Reply rep, Question que, User user) {
		super();
		this.rep = rep;
		this.que = que;
		this.user = user;
	}

}
