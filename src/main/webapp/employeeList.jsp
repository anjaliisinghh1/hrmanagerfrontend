<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h3{
color: #023e8a;
}
h4{
margin-left: 85%;
}
.showasbutton{
	text-decoration: none;
	padding-left: 6px;
	padding-right: 6px;
	padding-top: 1px;
	padding-bottom: 1px;
	background-color: #ff4d6d;
	color: black;
	border: solid;
	border-width: thin;
	border-color: black;
	border-radius: 1.5px;
	float:right;
}

#footer{
margin-left: 50%;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
<h3>List Employees Details</h3>
<h4>Welcome <%=session.getAttribute("username") %> !</h4>
<p ><strong>Employee Listing</strong><a class="showasbutton" href="logout"><button style="float: right;">Logout</button></a></p><br>
	<a href="uploadEmployeeDetails"><button style="float: right;">Upload Employee Details</button></a>
	<a href="downloadCSV"><button style="float: right;">Download Employee Details</button></a>
	<table border="1" align="center" style="width: 100%">
	    <tr>
			<th>Employee Code</th>
			<th>Employee Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>Date Of Birth</th>
			<th>Action</th>
		</tr>
		<tbody id="mytable">
		
		</tbody>
	</table>
	<script >
		var str = ${employee};
		buildTable(str);
		function buildTable(data)
		{
			var table=document.getElementById('mytable');
			for(let i=0;i<str.length;i++)
				
				
				{
var row='<tr><td>'+data[i].employeeCode+'</td><td>'+data[i].employeeName+'</td> <td>'+data[i].location+'</td><td>'+data[i].email+'</td> <td>'+data[i].dateOfBirth+'</td><td>'
+ '<a href="editEmployee/'+(i+1) +'">Edit</a>'
+ '</td> </tr>'
	table.innerHTML += row;
				}
		} 
		
	</script>
<footer id="footer">@Nagarro Software</footer>
</body>
</html>