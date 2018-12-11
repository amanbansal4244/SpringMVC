   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    isELIgnored="false"
    %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/13.Spring_MVC_Pagination/viewemp/1">1</a>   
   <a href="/13.Spring_MVC_Pagination/viewemp/2">2</a>   
   <a href="/13.Spring_MVC_Pagination/viewemp/3">3</a>  