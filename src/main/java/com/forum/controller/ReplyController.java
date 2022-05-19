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
import com.forum.Dao.ReplyDao;
import com.forum.Entity.QuestionList;
import com.forum.Entity.Reply;
import com.forum.Entity.ReplyDetail;
import com.forum.Entity.User;
import com.forum.exception.ForumException;

@Controller
public class ReplyController {

	@Autowired
	QuestionDao questionDao;
	@Autowired
	ReplyDao replyDao;

	@RequestMapping("/reply")
	public ModelAndView replyQue(@RequestParam("qno") int qno) {
		QuestionList quedetail = questionDao.getQuestionDetail(qno).get(0);
		System.out.println(quedetail);
		ModelAndView mv = new ModelAndView();
		//mv.addObject("queDetail", quedetail);
		mv.setViewName("reply");
		mv.addObject("reply", new Reply());
		mv.addObject("qid", quedetail.getQue().getQuestion_id());
		mv.addObject("title", quedetail.getQue().getUpload_title());
		mv.addObject("about", quedetail.getQue().getUpload_question());
		mv.addObject("uploader", quedetail.getName());
		return mv;

	}

	@RequestMapping("/replySave")
	public ModelAndView replySave(@ModelAttribute("reply") Reply reply, HttpSession session) {
		reply.setReply_date(Date.valueOf(LocalDate.now()));
		User login = (User) session.getAttribute("user");
		if (login == null) {
			throw new ForumException("You cannot reply question!Please Login");
		}
		reply.setForum_user_id(login.getId());
		System.out.println(reply);
		replyDao.savedReply(reply);
		System.out.println("save Reply");
		ReplyDetail replied = replyDao.getReply().get(0);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("replySave");
		mv.addObject("replied", replied);
		return mv;
	}

	@RequestMapping("/showReply")
	public ModelAndView showReply(@RequestParam("qno") int qno) {
		List<Reply> replies = replyDao.getReplies(qno);
		if (replies.size()==0) {
			throw new ForumException("There is no reply question");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("replies", replies);
		mv.setViewName("showReply");
		return mv;

	}
}
