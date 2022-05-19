package com.forum.service;

public interface QuestionService {
	int NUM_QUE_PER_PAGE = 3;
	int no_of_page(int queCount);
	int que_start(int page, int total);
	int que_end(int page, int total);

}
