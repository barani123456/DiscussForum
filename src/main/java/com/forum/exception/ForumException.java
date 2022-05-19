package com.forum.exception;

public class ForumException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ForumException(String msg) {
		super();
		this.msg = msg;
	}

	public ForumException() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
