package com.forum.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.forum.Dao.ReplyDao;
import com.forum.Entity.Question;
import com.forum.Entity.Reply;
import com.forum.Entity.ReplyDetail;
import com.forum.Entity.User;
import com.forum.exception.ForumException;

public class ReplyDaoImpl implements ReplyDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void savedReply(Reply reply) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "insert into reply (reply_date,reply_ans,question_id,forum_user_id)values (?,?,?,?)";
		try {

			template.update(sql, new Object[] { reply.getReply_date(), reply.getReply_ans(), reply.getQuestion_id(),
					reply.getForum_user_id() });

		} catch (Exception e) {
			throw new ForumException("Your Reply cannot be recorded");
		}

	}

	public List<ReplyDetail> getReply() {
		String sql = "select reply.*,question.*,forumuser.* from reply,question,forumuser where reply.reply_id=(select max(reply_id)from reply) and reply.question_id=question.question_id and reply.forum_user_id=forumuser.id";
		//	String sql = "select * from  reply where reply_id=(select max(reply_id) from reply)";
		return template.query(sql, new RowMapper<ReplyDetail>() {

			public ReplyDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReplyDetail detail = new ReplyDetail();
				Reply reply = new Reply();
				reply.setReply_date(rs.getDate(2));
				reply.setReply_ans(rs.getString(3));
				Question que = new Question();
				que.setUpload_title(rs.getString(8));
				que.setUpload_question(rs.getString(9));
				User user = new User();
				user.setName(rs.getString(12));
				detail.setQue(que);
				detail.setRep(reply);
				detail.setUser(user);
				return detail;
			}

		});

	}

	public List<Reply> getReplies(int q_id) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "select * from reply where question_id=?";
		return template.query(sql, new Object[] { q_id }, new RowMapper<Reply>() {

			public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO 自動生成されたメソッド・スタブ
				Reply reply = new Reply();
				//	reply.getQuestion_id(rs.getInt(4));
				reply.setReply_id(rs.getInt(1));
				reply.setReply_date(rs.getDate(2));
				reply.setReply_ans(rs.getString(3));
				reply.setQuestion_id(rs.getInt(4));
				//reply.getForum_user_id();
				reply.setForum_user_id(rs.getInt(5));
				return reply;
			}

		});
		//	return null;
	}
}