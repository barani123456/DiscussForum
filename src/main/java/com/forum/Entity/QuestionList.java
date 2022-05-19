package com.forum.Entity;

public class QuestionList {
	private Question que;
	private String name;

	public Question getQue() {
		return que;
	}

	public void setQue(Question que) {
		this.que = que;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuestionList() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public QuestionList(Question que, String name) {
		super();
		this.que = que;
		this.name = name;
	}

	@Override
	public String toString() {
		return "QuestionList [que=" + que + ", name=" + name + "]";
	}

}
