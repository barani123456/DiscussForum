package com.forum.DaoImpl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.forum.Dao.UserDao;
import com.forum.Entity.Question;
import com.forum.Entity.Role;
import com.forum.Entity.User;

public class UserDaoImpl implements UserDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public User loginCheck(String name, String password) {
		System.out.println(name);
		System.out.println(password);

		// TODO 自動生成されたメソッド・スタブ
		String sql = "select * from forumuser where name=? and password=?";
		//template.queryForObject(sql, new Object[] {name,password},new BeanPropertyRowMapper<User>());
		try {

			User user = template.queryForObject(sql, new Object[] { name, password },
					new BeanPropertyRowMapper<User>(User.class));
			//System.out.println(user);
			return user;

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;

		}
	}

	public User savedUser(User user) {
		// TODO 自動生成されたメソッド・スタブ

		String sql = "insert into forumuser (name,password,email,role) values (?,?,?,?)";
		template.update(sql, user.getName(), user.getPassword(), user.getEmail(), Role.ADMIN.name());
		String sql1 = "select * from forumuser where email=?";
		//System.out.println(user.getEmail());
		return template.queryForObject(sql1, new Object[] { user.getEmail() },
				new BeanPropertyRowMapper<User>(User.class));

		//		return null;
	}

	public User questionUser(Question question) {
		// TODO 自動生成されたメソッド・スタブ

		String sql = "insert into question (upload_date,upload_title,upload_question,uploader) values (?,?,?,?)";
		//	template.update(sql, question.getName(), quesrion.getPassword(), Role.ADMIN.name());
		template.update(sql, question.getUpload_date(), question.getUpload_title(), question.getUpload_question(),
				question.getUploader());
		return null;
	}

	public boolean checkExists(String email) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "select count(id) from forumuser where email=?";
		int count =template.queryForObject(sql, new Object[] { email }, Integer.class);
	if ( count != 0) {
			return false;

		} else {
			return true;
		}
}

	public boolean savePic(int id, String fname) {
		String sql="UPDATE forumuser SET pic=? WHERE id=?";
		template.update(sql, new Object[]{fname, id});
		return false;

	}

	public User getUser(int id) {
		String sql="select * from forumuser where id=?";
		try{
		User user=template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
		return user;
		}catch (RuntimeException e){
		return null;
	}
}
}
