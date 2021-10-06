<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h4{
margin-left: 85%;
}
#code{
margin-left: 7%;
margin-bottom: 3px;
}
#ename{
margin-left: 6.5%;
margin-bottom: 3px;
}
#loc{
margin-left: 10.5%;
margin-bottom: 3px;
}
#e{
margin-left: 12%;
margin-bottom: 3px;
}
#dob{
margin-left: 8%;
margin-bottom: 3px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Upload Employee Details</h3>
 <h4>Welcome <%=session.getAttribute("username") %> !</h4>
<hr>
        <form action="uploademployee">
        	<div>
        	<label for="employeeCode">Employee Code:</label>
            <input id="code" type="text" name="employeeCode" id=" " class="mb-4">
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
            <input id="e" type="text" name="email" class="mb-4">
            </div>
            <div>
            <label for="dateOfBirth">Date Of Birth:</label>
            <input id="dob" type="text" name="dateOfBirth"  class="mb-4">
            </div>

            <button class="span" type="submit" class="btn btn-info col-2"> Save </button>
            
        </form>

<hr>
    </div>

</body>
</html>