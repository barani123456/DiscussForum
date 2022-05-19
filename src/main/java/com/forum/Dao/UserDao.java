package com.forum.Dao;

import com.forum.Entity.Question;
import com.forum.Entity.User;

public interface UserDao {
	public User loginCheck(String name, String password);

	public User savedUser(User user);

	public User questionUser(Question question);

	public boolean checkExists(String email);

	public boolean savePic(int id, String fname);

	public User getUser(int id);

}
