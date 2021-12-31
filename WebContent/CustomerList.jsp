<%@page import="com.pharmacy.dao.CustomerDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.pharmacy.pojo.Customer"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>
		
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Customer List</strong>
          </div>
        </div>
      </div>
    </div>
		<div>
		<% List<Customer> customerlist = (List<Customer>)session.getAttribute("custlist");
			
			String user=(String)session.getAttribute("user");
			String status=(String)request.getAttribute("status");
			if(status!=null)
			out.print("<h3 id='a'>"+status+" !!!");
		%>
		</div>
		<% CustomerDaoImpl cdao = new CustomerDaoImpl(); %>
		
	<div>
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <tr id="b">	
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Customer Email Id</th>
				<th>Customer Password</th>
				<th>Contact Number</th>
				<th>Customer Address</th>
				<th colspan=2>Action</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(Customer cust : customerlist)
				{
					String password=cdao.getEncryptedPassword(cust.getCustomerPassword());
			%>
			<tr>
				<td><h2 class="h5 text-black"><%= cust.getCustomerId() %></h2></td>
				<td><h2 class="h5 text-black"><%= cust.getCustomerName() %></h2></td>
				<td><h2 class="h5 text-black"><%= cust.getCustomerEmailId() %></h2></td>
			<!--<td><h2 class="h5 text-black"><%= cust.getCustomerPassword() %></h2></td>-->
				<td><h2 class="h5 text-black"><%= password %></h2></td>
				<td><h2 class="h5 text-black"><%= cust.getContactNumber() %></h2></td>
				<td><h2 class="h5 text-black"><%= cust.getCustomerAddress() %></h2></td>
				
				<td><a href="CustomerServlet?action=delete&custid=<%= cust.getCustomerId() %>">Delete</a></td>
				<td><a href="CustomerServlet?action=update&custemailid=<%= cust.getCustomerEmailId() %>">Update</a></td>
				
			</tr>
			<%
				}
			%>
		</tbody>
		</table>
		</div>
		</form>
		</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
		
</body>
</html>