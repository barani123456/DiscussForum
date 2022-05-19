package com.forum.Dao;

import java.util.List;

import com.forum.Entity.Question;
import com.forum.Entity.QuestionList;

public interface QuestionDao {
	public void saveQuestion(Question que);

	public List<QuestionList> retrieveAllQue(int start, int end);

	public int getTotalQueueCount();

	public List<QuestionList> getQuestionDetail(int qid);

}
