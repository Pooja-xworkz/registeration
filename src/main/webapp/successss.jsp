<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"> 

</head>
<body>
<div class="container">
   <div class="card">
   <div class="card-body">
    <form action="<%=request.getContextPath()%>/success" >
    <div class="form-group row">
      <label for="email" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="email"
        placeholder="Enter your Email">
      </div>
     </div>
     <button type="submit" class="btn btn-primary">Submit</button>
     </form>
     </div>
     </div>
     </div>
    
      <form>
     <c:choose>
  <c:when test="${success!=null}">
  
   <table name="id" class="table table-dark" align="center">
     <thead class="thead">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Sur_Name</th>
                <th scope="col">Address</th>
                <th scope="col">Phone_no</th>

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