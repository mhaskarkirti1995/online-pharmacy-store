<%@page import="com.pharmacy.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<% List<Order> orderlist=(List<Order>)session.getAttribute("ordlist"); %>
		
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Order List</strong>
          </div>
        </div>
      </div>
    </div>
    
    <%
		String status=(String)request.getAttribute("status");
		if(status!=null)
			out.print(" <h3 id='a'> "+ status+" !!!");
	%>
    <%
    	String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
    %>
    <div>
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <tr id="b">	
						<th>Order Id</th>
						<th>Customer Email Id</th>
						<th>Order Status</th>
						<th>Total Bill</th>
						<th>Order Date</th>
						<%if(admin==null && user!=null) { %>
						<th>Action</th>
						<%} %>
					</tr>
				</thead>
				
		<% for(Order ord : orderlist ) { %>
				
			<tr>
				<td><h2 class="h5 text-black"><%=ord.getOrderId() %></h2></td>
				<td><h2 class="h5 text-black"><%=ord.getCustomerEmailId() %></h2></td>
				<td><h2 class="h5 text-black"><%=ord.getOrderStatus() %></h2></td>
				<td><h2 class="h5 text-black"><%=ord.getTotalBill() %></h2></td>
				<td><h2 class="h5 text-black"><%=ord.getOrderdate() %></h2></td>
				
				<%if(admin==null && user!=null) { %>
				 
			<td><h2 class="h5 text-black"><a href="OrderServlet?action=cancelorder&orderid=<%= ord.getOrderId() %>">CancelOrder</a></h2></td>
			</tr>
			<%} %>
		<% } %>		
		</table>
		</div>
		</form>
		</div>
		</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>