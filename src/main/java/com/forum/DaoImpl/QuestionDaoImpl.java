package com.forum.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.forum.Dao.QuestionDao;
import com.forum.Entity.Question;
import com.forum.Entity.QuestionList;

public class QuestionDaoImpl implements QuestionDao {
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void saveQuestion(Question question) {
		// TODO 自動生成されたメソッド・スタブ

		String sql = "insert into question (upload_date,upload_title,upload_question,uploader) values (?,?,?,?)";
		//	template.update(sql, question.getName(), quesrion.getPassword(), Role.ADMIN.name());
		template.update(sql, question.getUpload_date(), question.getUpload_title(), question.getUpload_question(),
				question.getUploader());
		System.out.println("question save");

	}

	public List<QuestionList> retrieveAllQue(int start, int end) {
		// TODO 自動生成されたメソッド・スタブ
		//String sql = "select question.* ,forumuser.name from question ,forumuser where question.uploader=forumuser.id";
		String sql = "select question.* ,forumuser.name from question ,forumuser where question.uploader=forumuser.id limit ?,?";
		return template.query(sql, new Object[] { start, end }, new RowMapper<QuestionList>() {
			public QuestionList mapRow(ResultSet rs, int arg1) throws SQLException {
				Question que = new Question();
				que.setQuestion_id(rs.getInt(1));
				que.setUpload_date(rs.getDate(2));
				que.setUpload_title(rs.getString(3));
				que.setUpload_question(rs.getString(4));
				que.setUploader(rs.getInt(5));
				QuestionList que_list = new QuestionList();
				que_list.setQue(que);
				que_list.setName(rs.getString(6));
				System.out.println("que_list" + que_list);
				return que_list;

			}
		});
	}

	public int getTotalQueueCount() {
		String sql = "select count(question_id) from question";
		return template.queryForObject(sql, Integer.class);

	}

	public List<QuestionList> getQuestionDetail(int qid) {
		// TODO 自動生成されたメソッド・スタブ
		String sql = "select question.* ,forumuser.name from question ,forumuser where question.question_id=? and question.uploader=forumuser.id";
		//return template.queryForObject	(sql, new Object() []{qid},new BeanPropertyRowRapper<QuestionList>()၎သတ၎သတ၎ျျျီျျီၐျျျီျိ်){
		return template.query(sql, new Object[] { qid }, new RowMapper<QuestionList>() {

			public QuestionList mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO 自動生成されたメソッド・スタブ
				Question que = new Question();
				que.setQuestion_id(rs.getInt(1));
				//que.setUpload_date(rs.getDate(2));
				que.setUpload_title(rs.getString(3));
				que.setUpload_question(rs.getString(4));
				//	que.setUploader(rs.getInt(5));
				QuestionList que_list = new QuestionList();
				que_list.setQue(que);
				que_list.setName(rs.getString(6));
				System.out.println("que_list" + que_list);
				return que_list;
			}
		});

	}
}
