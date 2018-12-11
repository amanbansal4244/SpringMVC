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
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aman.Circle;

@Controller
public class JDBCDaoImpl_UsingSimpleJdbcTemplate extends SimpleJdbcDaoSupport {
	
	@RequestMapping("/insertNewCircleRecordUsingSimpleJdbcTemplateAction")
	public ModelAndView insertNewCircleRecordUsingSimpleJdbcTemplate(HttpServletRequest request, HttpServletResponse response){
		int circleId = Integer.parseInt(request.getParameter("t7"));
		String circleName = request.getParameter("t8");
		String sql = "INSERT INTO circleTable (id, name) VALUES (?,?)";
		Map<String, Object> parameters = new HashMap<String, Object>();
	
		getSimpleJdbcTemplate().update(sql,circleId, circleName);

		String newsql = "select * from circleTable where id =?";
			
		Circle circleObject = (Circle)getSimpleJdbcTemplate().queryForObject(newsql,new ParameterizedRowMapper(){
            public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            	Circle circle = new Circle();
    			circle.setId(resultSet.getInt("id"));
    			circle.setName(resultSet.getString("name"));
    			return circle;
            }
        }, circleId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayNewRecord.jsp");
		mv.addObject("NewCircleMapperName", circleObject);
		return mv;
	}
	
	@RequestMapping("/getCircleListClassMappingUsingSimpleJdbcTemplateAction")
	public ModelAndView getCircleListClassMappingUsingSimpleJdbcTemplate(HttpServletRequest request, HttpServletResponse response){
		String sql = "select * from circleTable";
		
	    List list = (List) getSimpleJdbcTemplate().query(sql, new ParameterizedRowMapper(){
            public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            	Circle circle = new Circle();
    			circle.setId(resultSet.getInt("id"));
    			circle.setName(resultSet.getString("name"));
    			return circle;
            }
        });
	    
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("listCircleMapper", list);
		return mv;
	}
}
