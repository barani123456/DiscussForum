package com.forum.Dao;

import java.util.List;

import com.forum.Entity.Reply;
import com.forum.Entity.ReplyDetail;

public interface ReplyDao {
	public void savedReply(Reply reply);

	public List<ReplyDetail> getReply();
	public List<Reply> getReplies(int q_id);

}
