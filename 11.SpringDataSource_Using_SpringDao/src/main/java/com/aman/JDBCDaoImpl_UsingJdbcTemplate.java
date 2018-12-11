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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aman.Circle;

@Controller
public class JDBCDaoImpl_UsingJdbcTemplate extends JdbcDaoSupport {
	
	@RequestMapping("/insertNewCircleRecordAction")
	public ModelAndView insertNewCircleRecord(HttpServletRequest request, HttpServletResponse response){
		int circleId = Integer.parseInt(request.getParameter("t3"));
		String circleName = request.getParameter("t4");
		String sql = "INSERT INTO circleTable (id, name) VALUES (?,?)";
		getJdbcTemplate().update(sql, new Object[]{circleId, circleName});
		
		 String newsql = "select * from circleTable where id =?";
		 Circle circleObject = (Circle) getJdbcTemplate().queryForObject(newsql, new Object[] {circleId}, new CircleMapper());
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("displayNewRecord.jsp");
		 mv.addObject("NewCircleMapperName", circleObject);
		 return mv;
	}
	
	@RequestMapping("/createNewTableInDbAction")
	public void createNewTable(){
		String sql = "create table circleTable2 (id varchar(40) not null PRIMARY KEY, name varchar(25))";
		getJdbcTemplate().execute(sql);
	}
	
	@RequestMapping("/getCircleNameSimpleMapping")
	public ModelAndView getCircleName(HttpServletRequest request, HttpServletResponse response){
		int circleId = Integer.parseInt(request.getParameter("t1"));
		String sql = "select name from circleTable where id =?";
		String name = (String) getJdbcTemplate().queryForObject(sql, new Object[] {circleId}, String.class);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("circleName", name);
		return mv;
	}
	
	@RequestMapping("/getCircleCountMapping")
	public ModelAndView getCircleCount(){
		String sql = "select count(*) from circleTable";
		int count = getJdbcTemplate().queryForInt(sql);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("circleCount", count);
		return mv;
	}
	
	@RequestMapping("/getCircleNameClassMapping")
	public ModelAndView getCircleNameUsingRowMapper(HttpServletRequest request, HttpServletResponse response){
		int circleId = Integer.parseInt(request.getParameter("t2"));
		String sql = "select * from circleTable where id =?";
	    Circle circleObject = (Circle) getJdbcTemplate().queryForObject(sql, new Object[] {circleId}, new CircleMapper());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("circleMapperName", circleObject);
		return mv;
	}
	
	
	@RequestMapping("/getCircleListClassMapping")
	public ModelAndView getCircleListUsingRowMapper(HttpServletRequest request, HttpServletResponse response){
		String sql = "select * from circleTable";
		 List list = (List) getJdbcTemplate().query(sql, new RowMapper(){
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
	
	private static final class CircleMapper implements RowMapper{

		public Circle mapRow(ResultSet resultSer, int rowNumber) throws SQLException {
			Circle circle = new Circle();
			circle.setId(resultSer.getInt("id"));
			circle.setName(resultSer.getString("name"));
			return circle;
		}
		
	}
}
