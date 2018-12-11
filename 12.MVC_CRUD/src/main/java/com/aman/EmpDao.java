package com.aman;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;  
  
public class EmpDao {  
	private JdbcTemplate template;  

	public void setTemplate(JdbcTemplate template) {  
		this.template = template;  
	}  
	public int save(Emp p){  
		String sql="insert into employeeObj(id,name,salary,designation) values('"+p.getId()+"','"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";  
				return template.update(sql);  
	}
	
	public int update(Emp p){  
		String sql="update employeeObj set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
				return template.update(sql);  
	} 
	
	public int delete(int id){  
		String sql="delete from employeeObj where id="+id+"";  
		return template.update(sql);  
	} 
	
	public Emp getEmpById(int id){  
		String sql="select * from employeeObj where id=?";  
		return (Emp) template.queryForObject(sql, new Object[]{id},new RowMapper(){  
			public Emp mapRow(ResultSet rs, int row) throws SQLException {  
				Emp e=new Emp();  
				e.setId(rs.getInt(1));  
				e.setName(rs.getString(2));  
				e.setSalary(rs.getFloat(3));  
				e.setDesignation(rs.getString(4));  
				return e;  
			}  
		});  
	} 
	
	public List<Emp> getEmployees(){  
		String sql= "select * from employeeObj";
		return template.query(sql, new RowMapper(){  
			public Emp mapRow(ResultSet rs, int row) throws SQLException {  
				Emp e=new Emp();  
				e.setId(rs.getInt(1));  
				e.setName(rs.getString(2));  
				e.setSalary(rs.getFloat(3));  
				e.setDesignation(rs.getString(4));  
				return e;  
			}  
		});  
	}  
}  
