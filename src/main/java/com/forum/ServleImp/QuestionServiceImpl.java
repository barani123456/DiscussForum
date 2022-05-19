package com.forum.ServleImp;

import com.forum.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	public int no_of_page(int queCount) {
		// TODO 自動生成されたメソッド・スタブ
		return (queCount % NUM_QUE_PER_PAGE == 0) ? queCount / NUM_QUE_PER_PAGE : (queCount / NUM_QUE_PER_PAGE) + 1;
		//	return 0;
	}

	public int que_start(int page, int total) {
		// TODO 自動生成されたメソッド・スタブ
		int start=(total-(page*NUM_QUE_PER_PAGE));
		return (start<=0)?0:start;
		//return 0;
	}

	public int que_end(int page, int total) {
		// TODO 自動生成されたメソッド・スタブ
		return (page*NUM_QUE_PER_PAGE>total)?total%NUM_QUE_PER_PAGE:NUM_QUE_PER_PAGE;
		//return 3;
	}

}
