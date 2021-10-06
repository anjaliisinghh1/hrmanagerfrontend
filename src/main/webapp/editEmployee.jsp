<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2{
color: #023e8a;
}
h3{
color: #023e8a;
}
h4{
margin-left: 85%;
}

.epage{
margin-left:10%; 
}

#code{
background-color: #e9ecef;
margin-left: 2.2%;
margin-bottom: 2%;
}
#ename{
margin-left: 2%;
margin-bottom: 2%;
}
#loc{
margin-left: 6.5%;
margin-bottom: 2%;
}
#email{
margin-left: 8%;
margin-bottom: 2%;
}
#dob{
margin-left: 3.5%;
margin-bottom: 2%;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
<h2>Edit Details</h2>
 <h3>Edit employee Details</h3>
 <h4>Welcome <%=session.getAttribute("username") %> !</h4>
 <div class="epage">
        <form action="editEmployeeDetails" method="get">
        	<div>
        	<label for="employeeCode">Employee Code:</label>
            <input id="code" type="text" name="employeeCode" id=" " class="mb-4" readonly>
            </div>
            <div>
            <label for="employeeName">Employee Name:</label>
            <input id="ename" type="text" name="employeeName" class="mb-4">
            </div>
            <div>
            <label for="location"> Location:</label>
            <input id="loc" type="text" name="location"  class="mb-4">
            </div>
            <div>
            <label for="email"> Email:</label>
            <input id="email" type="text" name="email" class="mb-4">
            </div>
            <div>
            <label for="dateOfBirth">Date Of Birth:</label>
            <input id="dob" type="text" name="dateOfBirth"  class="mb-4">
            </div>

             <button class="span" type="submit"> Save </button>
            
        </form>
</div>
    <script>
		var str = ${employee};
		document.getElementById("code").value=str.employeeCode;
		document.getElementById("ename").value=str.employeeName;
		document.getElementById("loc").value=str.location;
		document.getElementById("email").value=str.email;
		document.getElementById("dob").value=str.dateOfBirth;
		</script>
	<footer align="center">@Nagarro Software</footer>
</body>
</html>