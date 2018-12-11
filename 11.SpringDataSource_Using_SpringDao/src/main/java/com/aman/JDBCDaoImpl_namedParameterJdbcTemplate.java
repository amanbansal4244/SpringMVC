package com.aman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aman.Circle;

@Controller
public class JDBCDaoImpl_namedParameterJdbcTemplate extends NamedParameterJdbcDaoSupport{

	@RequestMapping("/insertNewCircleRecordUsingNamedParameterJdbcTemplateAction")
	public ModelAndView insertNewCircleRecordUsingNamedParameterJdbcTemplate(HttpServletRequest request, HttpServletResponse response){
		int circleId = Integer.parseInt(request.getParameter("t5"));
		String circleName = request.getParameter("t6");
		String sql = "INSERT INTO circleTable (id, name) VALUES (:id,:name)";
		/*SqlParameterSource sqlParameterSource = new MapSqlParameterSource("id", circleId)
														.addValue("name", circleName);
		getNamedParameterJdbcTemplate().update(sql, sqlParameterSource);*/

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id",circleId);
		parameters.put("name", circleName);
		getNamedParameterJdbcTemplate().update(sql, parameters);

		String newsql = "select * from circleTable where id =:id";
		Map<String, Object> parameters1 = new HashMap<String, Object>();
		parameters1.put("id",circleId);
		
		Circle circleObject = (Circle) getNamedParameterJdbcTemplate().queryForObject(newsql, parameters1, new RowMapper(){
            public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            	Circle circle = new Circle();
    			circle.setId(resultSet.getInt("id"));
    			circle.setName(resultSet.getString("name"));
    			return circle;
            }
        });

				
				//queryForObject(newsql, new Object[] {circleId}, new CircleMapper());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayNewRecord.jsp");
		mv.addObject("NewCircleMapperName", circleObject);
		return mv;
	}
}
