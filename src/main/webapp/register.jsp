<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Registeration Form</title>
</head>
<body>

	<form action="register" modelattribute="register" method="post">
		<section class="h-100 bg-dark">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col">
						<div class="card card-registration my-4">
							<div class="row g-0">
								<div class="col-xl-6 d-none d-xl-block">
									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
										alt="Sample photo" class="img-fluid"
										style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
								</div>
								<div class="col-xl-6">
									<div class="card-body p-md-5 text-black">
										<h3 class="mb-5 text-uppercase">Registration form</h3>
										<h1>${message }</h1>
										<h1>${error_message }</h1>
										<div class="row">
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<input type="text" name="name" id="form3Example1m"
														class="form-control form-control-lg" /> <label
														class="form-label" for="form3Example1m">First name</label>
												</div>
											</div>
											<div class="col-md-6 mb-4">
												<div class="form-outline">
													<input type="text" name="surName" id="form3Example1n"
														class="form-control form-control-lg" /> <label
														class="form-label" for="form3Example1n">Sur_Name</label>
												</div>
											</div>
										</div>

										<div class="form-outline mb-4">
											<input type="text" name="address" id="form3Example8"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example8">Address</label>
										</div>

										<div class="form-outline mb-4">
											<input type="text" name="dateOfBirth" id="form3Example8"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example8">Date_Of_Birth</label>
										</div>

										<div class="form-outline mb-4">
											<input type="text" name="phoneNo" id="form3Example97"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example97">Mobile-no</label>
										</div>

										<div class="form-outline mb-4">
											<input type="text" name="email" id="form3Example97"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example97">Email ID</label>
										</div>

										<div class="form-outline mb-4">
											<input type="text" name="zip" id="form3Example90"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example90">Pincode</label>
										</div>


										<div class="d-flex justify-content-end pt-3">
											<input type="submit" name='REGISTER' value="Submit"
												class="btn btn-warning btn-lg ms-2">
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>