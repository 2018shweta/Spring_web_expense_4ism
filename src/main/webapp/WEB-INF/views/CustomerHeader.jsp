<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">Exp_tracker</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
		<li class="nav-item dropdown header-profile"><a
							class="nav-link" href="#" role="button" data-toggle="dropdown">
								<img src="images\2\33e0a8de-c30c-4bbd-b357-7d3d53b6dfe5.jpg"
								width="20" alt="">
								<div class="header-info">
									<span>Johndoe</span> 
								</div>
						</a></li>
						<li class="nav-item active"><a class="nav-link"
				href="newprofile">Add Profile <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="Dashboard.jsp">CUSTOMER <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="addaccount">AddAccount</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="expense">AddExpense <span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item active"><a class="nav-link"
				href="expenselist">AllExpenseList <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="addcategory">AddCategory <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="addsubcategory">Add SubCategory <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="accountDetails">AccountDetails <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="categorychart">ExpenseChart <span class="sr-only">(current)</span>
			</a></li>

		</ul>
		
		<form class="form-inline my-2 my-lg-0">

			<!--  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">My Carts</button>-->
			<a href="logout"
				class="btn btn-outline-success my-2 my-sm-0">Logout</a>
		</form>

		<form class="form-inline my-2 my-lg-0">

			<!--  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">My Carts</button>-->
			<a href="DisableController"
				class="btn btn-outline-success my-2 my-sm-0">Ac Disable</a>
		</form>
	</div>
</nav>