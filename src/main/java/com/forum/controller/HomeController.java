package com.forum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.forum.Dao.UserDao;
import com.forum.Entity.Question;
import com.forum.Entity.User;

@Controller
public class HomeController {
	@Autowired
	UserDao userdao;

	@RequestMapping("/")
	public String root() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}

	@RequestMapping("/registration")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registration");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/question_upload")
	public ModelAndView question() {
		ModelAndView mandv = new ModelAndView();
		Question que = new Question();
		que.setQuestion_id(1);
		System.out.println(que);
		mandv.setViewName("question");

		/*	mandv.addObject("question", new Question());*/
		mandv.addObject("question", que);
		return mandv;
	}

	@RequestMapping("/index")
	public String menu() {
		System.out.println("menu");
		return "index";
	}
}
