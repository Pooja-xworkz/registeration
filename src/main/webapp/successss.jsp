<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<form action="success" modelAttribute="entity">
					<h1>${message }</h1>

					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="email"
								placeholder="Enter your Email">
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-2 col-form-label">Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								placeholder="Enter your Name">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>


			<form>
				<c:choose>
					<c:when test="${success!=null}">

						<table name="id" class="table" align="center">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Name</th>
									<th scope="col">Sur_Name</th>
									<th scope="col">Address</th>
									<th scope="col">Phone_no</th>
									<th scope="col">Date_Of_Birth</th>
									<th scope="col">Email</th>
									<th scope="col">Action</th>

								</tr>
							</thead>
							<tbody>

								<tr>
									<td>${success.name}</td>
									<td>${success.surName}</td>
									<td>${success.address}</td>
									<td>${success.phoneNo}</td>
									<td>${success.dateOfBirth}</td>
									<td>${success.email}</td>
									<td><a href="editemp/${success.email}">Edit</a></td>
								</tr>

							</tbody>

							
						</table>
</c:when>
	</c:choose>
	</form>
	<form>
	<c:choose>
						<c:when test="${success2!=null}">
							<table name="id" class="table" align="center">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Name</th>
										<th scope="col">Sur_Name</th>
										<th scope="col">Address</th>
										<th scope="col">Phone_no</th>
										<th scope="col">Date_Of_Birth</th>
										<th scope="col">Email</th>
										<th scope="col">Action</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${success2}" var="success2">

										<tr>

											<td>${success2.name}</td>
											<td>${success2.surName}</td>
											<td>${success2.address}</td>
											<td>${success2.phoneNo}</td>
											<td>${success2.dateOfBirth}</td>
											<td>${success2.email}</td>
											<td><a href="editemp/${success2.email}">Edit</a></td>

										</tr>

									</c:forEach>

								</tbody>


							</table>
						</c:when>
				</c:choose>
			</form>

			<form id="edit" action="editsave/${command.email}" method="post"
				modelAttribute="entity">
				<c:choose>
					<c:when test="${command!=null}">

						<h1>edit here</h1>
						Email  :  <input type="text" disabled name="email"
							value=${command.email }>
						<br> 
						First name  : <input type="text" name="name"
							value=${command.name }>
						<br> Surname  : <input type="text" name="surName"
							value=${command.surName }>
						<br>
						Address  : <input type="text" name="address"
							value=${command.address }>
						<br> MobileNo  :  <input type="text" name="phoneNo"
							value=${command.phoneNo }>
						<br>
							Zip  :  <input type="text" name="zip" value=${command.zip }>
						<br>
					DateOfBirth  :  <input type="text" name="dateOfBirth"
							value=${command.dateOfBirth }>
						<br>
						<br>
						<br>
						<input type="submit" id="edit" value="submit">

					</c:when>
				</c:choose>
			</form>
			<form>
				<c:choose>
					<c:when test="${msg!=null}">

						<table name="id" class="table" align="center">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Name</th>
									<th scope="col">Sur_Name</th>
									<th scope="col">Address</th>
									<th scope="col">Phone_no</th>
									<th scope="col">Date_Of_Birth</th>
									<th scope="col">Email</th>


								</tr>
							</thead>
							<tbody>

								<tr>
									<td>${msg.name}</td>
									<td>${msg.surName}</td>
									<td>${msg.address}</td>
									<td>${msg.phoneNo}</td>
									<td>${msg.dateOfBirth}</td>
									<td>${msg.email}</td>

								</tr>

							</tbody>


						</table>
					</c:when>
				</c:choose>
			</form>


		</div>
	</div>

</body>
</html>