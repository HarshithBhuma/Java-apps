<html>
<body bgcolor = "wheat">

<h1>Hospital Application</h1>
<br><br><br>

<%@page import= "java.util.*" %>
<%@page import= "com.ex.*" %>
<%@page import= "com.user.*" %>


<%

%>
<form action="updatePatient" method="post">
<input type= "hidden" name="pid" value=<%=p.getPid() %> >
<input type = "text" name = "name" value=<%=p.getName() %>>
<input type = "number" name = "age" value=<%=p.getAge() %>>
<input type = "text" name = "location" value=<%=p.getLocation() %>>
<input type = "submit" value="Update Patient">

</form>


</body>
</html>
 
