package com.forum.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*import javax.validation.Valid;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.forum.Dao.UserDao;
import com.forum.Entity.User;
import com.forum.exception.ForumException;

@Controller
public class UserController {
	@Autowired
	UserDao userdao;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpSession session) {
		//System.out.println(name + ":" + password);
		User user = userdao.loginCheck(name, password);
		ModelAndView mv = new ModelAndView();
		if (user == null) {
			mv.setViewName("login");
			session.setAttribute("user_login", "not match");
		} else {
			System.out.println(user);
			session.removeAttribute("user_login");
			session.setAttribute("user", user);
			mv.setViewName("UserInfo");
			mv.addObject("user", user);
		}
		return mv;
		//return "UserInfo";
	}

	@RequestMapping("/registered")
	public ModelAndView saveUser(@ModelAttribute("user") User user, HttpSession session) {

		/*	if (result.hasErrors()) {
				System.out.println("result is"+result);
				List<ObjectError> errors = result.getAllErrors();
				for (ObjectError error : errors)
					System.out.println(error);

			}*/
		boolean b = userdao.checkExists(user.getEmail());
		if (!b) {
			throw new ForumException("Email is already exists");
		}
		System.out.println(user);
		user = userdao.savedUser(user);
		session.setAttribute("user", user);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping("/uploadPhoto")
	public String uploadPhoto() {
		return "uploadPhoto";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("pic") CommonsMultipartFile file, HttpSession session) throws IOException {
		System.out.println("in file save");
		String source = ("resources/css" + File.separator + "img");
		String path = servletContext.getRealPath("/") + source;
		String fname = file.getOriginalFilename();
		String fullpath = path + File.separator + fname;
		System.out.println("full path: " + fullpath);
		byte[] b = file.getBytes();

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullpath)));
		stream.write(b);
		stream.flush();
		stream.close();
		System.out.println("file wrote");
		User c = (User) session.getAttribute("user");
		userdao.savePic(c.getId(), fname);
		session.setAttribute("user", userdao.getUser(c.getId()));
		return "index";
	}

	@RequestMapping("/download_file")
	public String download(HttpServletResponse response, @RequestParam("photo") String photo) throws IOException {
		PrintWriter writer = response.getWriter();
		String source = "resources/css" + File.separator + "img";
		String path = servletContext.getRealPath("/") + source;
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=" + photo);
		System.out.println(path + photo);

		FileInputStream inputStream = new FileInputStream(path + File.separator + photo);
		int i;
		while ((i = inputStream.read()) != -1) {
			writer.write(i);
		}
		inputStream.close();
		writer.close();
		return "UserInfo";
	}
}
