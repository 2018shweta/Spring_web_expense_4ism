<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>


.card-registration .select-input.form-control[readonly]:not([disabled]) {
font-size: 1rem;
line-height: 2.15;
padding-left: .75em;
padding-right: .75em;
}
.card-registration .select-arrow {
top: 13px;
}


</style>
</head>
<body>
<section class="h-100 bg-dark">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
            <form action="loginuser" method="post" >
        <div class="card card-registration my-4">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                alt="Sample photo" class="img-fluid"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">Login </h3>

                <div class="form-outline mb-4">
                  <input type="text" id="form3Example97" class="form-control form-control-lg" name="email" />
                  <label class="form-label" for="form3Example97">Email ID</label>
                </div>
                

               
                 
                    <div class="form-outline">
                      <input type="password" id="form3Example1n1" class="form-control form-control-lg" name="password"/>
                      <label class="form-label" for="form3Example1n1">Password</label>
                    </div>
                  

              
              

                </div>

                <!-- <div class="row">
                  <div class="col-md-6 mb-4">

                    <select class="select">
                      <option value="1">State</option>
                      <option value="2">Option 1</option>
                      <option value="3">Option 2</option>
                      <option value="4">Option 3</option>
                    </select>

                  </div>
                  <div class="col-md-6 mb-4">

                    <select class="select">
                      <option value="1">City</option>
                      <option value="2">Option 1</option>
                      <option value="3">Option 2</option>
                      <option value="4">Option 3</option>
                    </select>

                  </div>
                </div> -->

               <!--  <div class="form-outline mb-4">
                  <input type="text" id="form3Example9" class="form-control form-control-lg" />
                  <label class="form-label" for="form3Example9">DOB</label>
                </div> -->

               

                <div class="d-flex justify-content-end pt-3">
                  <button type="button" class="btn btn-light btn-lg">SignUp</button>
                  <button type="submit" class="btn btn-warning btn-lg ms-2">Submit form</button>
                </div>

              </div>
            </div>
          </div>
        </div>
              </form>
      </div>
    </div>
  </div>
</section>

</body>
</html>