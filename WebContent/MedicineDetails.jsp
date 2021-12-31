<%@page import="com.pharmacy.pojo.Medicine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Details</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	
	
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Medicine Details</strong>
          </div>
        </div>
      </div>
    </div>
    <% Medicine med =(Medicine)session.getAttribute("med"); %>
	
    <%	String status=(String)request.getAttribute("status");
	
		if(status!=null)
			out.print("<h3 id='a'> Your item has  "+status+" !!!");
		
		String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
	%>
    <!-- <div class="site-section">
      <div class="container">
     -->    <div class="row">
          <div class="title-section text-center col-12">
            <h2 class="text-uppercase">Medicine Details</h2>
          </div>
        </div>
        <!-- </div>
        </div> -->
       <div>
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
        	<%-- <tr><th>Medicine Id</th><td><h2 class="h5 text-black"><%= med.getMedicineId() %></h2></td></tr> --%>
			<tr><th>Medicine Name</th><td><h2 class="h5 text-black"><%= med.getMedicineName() %></h2></td></tr>
			<tr><th>Medicine Type</th><td><h2 class="h5 text-black"><%= med.getMedicineType() %></h2></td></tr>
			<tr><th>Medicine Brand</th><td><h2 class="h5 text-black"><%= med.getMedicineBrand() %></h2></td></tr>
			<tr><th>Medicine Description</th><td><h2 class="h5 text-black"><%= med.getMedicineDescription() %></h2></td></tr>
			<tr><th>Medicine Quantity</th><td><h2 class="h5 text-black"><%= med.getMedicineQty() %></h2></td></tr>
			<tr><th>Medicine Manufacture Date</th><td><h2 class="h5 text-black"><%= med.getMfgDate() %></h2></td></tr>
			<tr><th>Medicine Expiry Date</th><td><h2 class="h5 text-black"><%= med.getExpiryDate() %></h2></td></tr>
			<tr><th>Medicine Price</th><td><h2 class="h5 text-black"><%= med.getMedicinePrice() %></h2></td></tr>
			
			<tr >
			<%if(admin!=null && user==null) {%>
			
			<td><a href="MedicineServlet?action=delete&medid=<%= med.getMedicineId() %>">Delete</a></td>
			<td><a href="MedicineServlet?action=update&medid=<%= med.getMedicineId() %>">Update</a></td>
			
			<%} %>
			
			<%  if(admin==null && user!=null) 
				{
					if(med.getMedicineQty()<=0)
					{
			%>
				<td></td><td><a href="" onclick="return false";><strike>Add To Cart  </strike></td><td><b style="color:red">Out Of Stock</b></a></td>
			<%} else { %>
				<td ></td><td><a href="CartServlet?action=addtocart&medid=<%= med.getMedicineId() %>">Add To Cart</a></td>
			<%} } %>
			</tr>
		</thead>
		</tbody>
		</table>
		</div>
		</form>
		</div>
		</div>
       	<jsp:include page="Footer.jsp"></jsp:include>
       
</body>
</html>