<html>
<body bgcolor = "wheat">

<h1>Patient Portal</h1>
<br><br><br>

<a href="add">Add Patient</a> |
<a href="display">View Patient</a>

<br><br>

<%@page import="com.ex.*"%>
<%@page import="java.util.*"%>
<table border="2" cellPadding = "20" width = "800" height = "200" align = "center">
<tr>
<td>Id</td><td>Name</td><td>Age</td><td>Location</td>
</tr>
<% 
List li = (List)request.getAttribute("list"); 
Iterator i = li.iterator();

while(i.hasNext()){
	Patient p = (Patient)i.next();
%>
<tr>
<td><%=p.getPid()%></td>
<td><%=p.getName()%></td>
<td><%=p.getAge()%></td>
<td><%=p.getLocation()%></td>
<td> 
<a href="update/<%= p.getPid() %>">Update</a> |
<a href="delete/<%= p.getPid() %>">Delete</a>
</td>

</tr>
	
<% } %>

</table>


</body>
</html>
