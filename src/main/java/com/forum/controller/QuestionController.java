package com.forum.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.forum.Dao.QuestionDao;
import com.forum.Entity.Question;
import com.forum.Entity.QuestionList;
import com.forum.Entity.User;
import com.forum.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	QuestionDao questionDao;

	@Autowired
	QuestionService questionservice;

	@RequestMapping("/question")
	public String uploaded_Que(@ModelAttribute("question") Question que, HttpSession session) {
		que.setUpload_date(Date.valueOf(LocalDate.now()));
		User user = (User) session.getAttribute("user");
		que.setUploader(user.getId());
		questionDao.saveQuestion(que);
		return "index";
	}

	@RequestMapping("/show_all_question")
	//public ModelAndView Show_All_Question(@ModelAttribute("show_all_question") Question que, HttpSession session) {
		public ModelAndView Show_All_Question(@RequestParam("pno")int pno) {
		int queCount = questionDao.getTotalQueueCount();
		int no_of_page = questionservice.no_of_page(queCount);
		int start_no =questionservice.que_start(pno,queCount);
		int end_no= questionservice.que_end(pno,queCount);
		System.out.println("queCount"+queCount);
		System.out.println("no_of_page"+no_of_page);
		List<QuestionList> all_que = questionDao.retrieveAllQue(start_no, end_no);
		System.out.println("all" + all_que);
		ModelAndView mv = new ModelAndView();
		mv.addObject("all_que", all_que);
		mv.addObject("pages", no_of_page);
		mv.setViewName("show_question");
		return mv;
	}
}
