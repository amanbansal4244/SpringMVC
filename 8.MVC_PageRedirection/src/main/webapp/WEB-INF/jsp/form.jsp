<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    isELIgnored="false"
    %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
   <head>
      <title>Spring Page Redirection</title>
   </head>

   <body>
      <h2>Spring Page Redirection</h2>
      <p>Click below button to redirect the result to new page</p>
      
      <form:form method = "GET" action="redirect">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Redirect Page"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
   
</html>