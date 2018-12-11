package com.aman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aman.Circle;

@Controller
public class JDBCDaoImpl {
	
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@RequestMapping("/JDBCDataSourceAction")
	public ModelAndView getCircle(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException{
		
		Connection con = null;
		int circleId = Integer.parseInt(request.getParameter("t1"));
		try{
			con =  dataSource.getConnection();
			String query ="select * from circleTable where id =?";
			Circle circle = null;
			Class.forName("com.mysql.jdbc.Driver"); //for name is a method which will help you to load the drivers.

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, circleId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				String name = rs.getString("name");
				circle = new Circle(circleId, name);
			}
			rs.close();
			ps.close();

			ModelAndView mv = new ModelAndView();
			mv.setViewName("display.jsp");
			mv.addObject("result", circle);

			return mv;

		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

}
