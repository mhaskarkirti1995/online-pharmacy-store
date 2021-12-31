<%@page import="com.pharmacy.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Receipt</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

<%-- 	java code replace with jstl code<%
	Order order=(Order)request.getAttribute("placeorder"); %> --%>
		
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Bill Receipt</strong>
          </div>
        </div>
      </div>
    </div>
    <div>
    	<% String status=(String)request.getAttribute("status");
			if(status!=null)
			out.print("<h3 id='a'>"+status+" !!!"); 
		%>
	</div>
		
	<c:if test="${placeorder!=null }">
	
    <div>
    <center><h2 class="h3 mb-5 text-black">Receipt</h2></center>
    </div>
   
    <div>
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <tr id="b">	
						<tr>
							<th>Order Id</th>
							<td>${placeorder.orderId}</td><%-- this line replace with<%= order.getOrderId()%> --%>
						</tr>
						<tr>
							<th>Customer Email Id</th>
							<td>${placeorder.customerEmailId}</td>
						</tr>
						<tr>
							<th>Order Status</th>
							<td>${placeorder.orderStatus}</td>
						</tr>
						<tr>	
							<th>Total Bill</th>
							<td>${placeorder.totalBill}</td>
						</tr>	
						<tr>	
							<th>Order Date</th>
							<td>${placeorder.orderdate}</td>
						</tr>	
				</thead>
				</table>
			</div>
		</form>
	</div>
</div>
		</c:if>
    	<c:if test="${placeorder==null}">
    	<center><h2 class="h5 text-black">No Order Placed !!! </h2></center>
    	</c:if>
    	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>