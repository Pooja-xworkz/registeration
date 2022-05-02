<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
<body>
<form  id="Otp" method="get" action="otp">
<div class="container height-100 d-flex justify-content-center align-items-center">
    <div class="position-relative">
        <div class="card p-2 text-center">
            <h6>Please enter the one time password <br> to verify your account</h6>
            <div> <span>A code has been sent to</span> <small>${entityEmail }</small> </div>
            <h1>${message }</h1> 
            <div class="inputs d-flex flex-row justify-content-center mt-2"> <input id="otp" name="otp" class="m-2 text-center form-control rounded" type="text"  maxlength="4" /> </div>
            <div class="mt-4"> <input type ="submit" class="btn btn-danger px-4 validate" id="Otp" value="Validate"></div>
        </div>
        <div class="card-2">
            <div class="content d-flex justify-content-center align-items-center"> <span>Didn't get the code</span> <a href="#" class="text-decoration-none ms-3">Resend(1/3)</a> </div>
        </div>
    </div>
</div>

</body>
</html>