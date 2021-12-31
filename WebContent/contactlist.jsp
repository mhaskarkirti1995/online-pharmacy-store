<%@page import="com.pharmacy.pojo.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	
<% List<Contact> contactlist=(List<Contact>)session.getAttribute("conlist"); %>
		
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Contact List</strong>
          </div>
        </div>
      </div>
    </div>
    <div>
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <tr id="b">	
						<th>Contact Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email Id</th>
						<th>Subject</th>
						<th>Message</th>
					</tr>
				</thead>
	<tbody>
		<% for(Contact con : contactlist)
		{ %>
				
			<tr>
				<td><h2 class="h5 text-black"><%=con.getContactId() %></h2></td>
				<td><h2 class="h5 text-black"><%=con.getFirstName() %></h2></td>
				<td><h2 class="h5 text-black"><%=con.getLastName() %></h2></td>
				<td><h2 class="h5 text-black"><%=con.getEmailId() %></h2></td>
				<td><h2 class="h5 text-black"><%=con.getSubject() %></h2></td>
				<td><h2 class="h5 text-black"><%=con.getMessage() %></h2></td>
			</tr>
			</tbody>
			<%} %>
			
		</table>
		</div>
		</form>
		</div>
		</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>