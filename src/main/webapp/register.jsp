<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<section class="vh-100" style="background-color: #9A616D;">
		<div class="container py-5 h-100">
			<div class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							<div class="col-md-6 col-lg-5 d-none d-md-block">
								<img
									src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
									alt="Sample photo" class="img-fluid"
									style="border-radius: 1rem 0 0 1rem;" />
							</div>
							<div class="col-md-6 col-lg-7 d-flex align-items-center">
								<div class="card-body p-md-5 text-black">
									<form action="register" modelattribute="register" method="post">
										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Registeration
											Form</h5>
										<h1>${message }</h1>
										<h1>${error_message }</h1>

										<div class="form-outline mb-4" >
											<input type="text" name="name" id="form2Example17"
												class="form-control form-control-lg" id="email" name="email" />
											<label class="form-label"  for="form2Example17">First
												Name</label>
										</div>

										<div class="form-outline mb-4">
											<input type="text" name="surName" id="form3Example1n"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example1n">Sur_Name</label>
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
												class="form-label" for="form3Example97">Mobile</label>
										</div>
										<div class="form-outline mb-4">
											<input type="text" path="email"name="email" id="form3Example97" path="email"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example97">Email ID</label>
										</div>
										<div class="form-outline mb-4">
											<input type="text" name="zip" id="form3Example90"
												class="form-control form-control-lg" /> <label
												class="form-label" for="form3Example90">Pincode</label>
										</div>

										<div class="pt-1 mb-4">
											<input class="btn btn-dark btn-lg btn-block" type="submit"
												name="REGISTER" id="login" value="Submit" />
										</div>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</section>
</body>
</html>