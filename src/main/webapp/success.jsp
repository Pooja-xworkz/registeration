<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<form action="success">
<h1>${message}</h1>
  <label for="email">Enter your email:</label>
  <input type="email" id="email" name="email">
  <input type="submit" value="Search">
  </form>
  <c:choose>
  <c:when test="${success!=null}">
  <table>
  <form>
  <table  name="id" border="1">
      <thead>
        <tr>
            <td>Name</td>
            <td>SurName</td>
            <td>Address</td>
            <td>MobileNo</td>
        </tr>
      </thead>
      <tbody>
     
            <tr>
                <td>${success.name}</td>
                <td>${success.surName}</td>
                <td>${success.address}</td>
                <td>${success.phoneNo}</td>
            </tr>
       
      </tbody>
  </table>
   </c:when>
 </c:choose>
  </form>


</body>

 
  
</html>