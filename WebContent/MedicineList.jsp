<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine List</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<%
		List<Medicine> medicinelist=(List<Medicine>)session.getAttribute("medlist");
	%>
	<form action="MedicineServlet">
    <input type="hidden" name="action" value="sort">
    
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Cart</strong>
          </div>
        </div>
      </div>
    </div>
    	
	<div>
	<%	String status=(String)request.getAttribute("status");
	
	 	if(status!=null)
			out.print("<h3 id='a'>" +status+" !!!"); 
		
		String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
	%>
	</div>
	
	<% if(admin!=null && user==null) {%>
		<div class="form-group row">
            <div class="col-lg-12">
          	   <input type="submit" name="medname" class="btn btn-primary btn-lg btn-block" value="sort (A-Z)">
    		 </div>
    	</div>
    	<%} %>
    	
	<div class="site-section">
      <div class="container">
        
        <div class="row">
          <div class="title-section text-center col-12">
            <h2 class="text-uppercase">Popular Products</h2>
          </div>
        </div>
    	</div>
    	</div>    
		
    	<div class="row">
    	<%
			for(Medicine med : medicinelist)
			{
		%>
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <a href="MedicineServlet?action=details&medid=<%= med.getMedicineId()%>"><img src="ImageController?medid=<%=med.getMedicineId() %>" 
            alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineServlet?action=details&medid=<%= med.getMedicineId()%>"><%= med.getMedicineName() %></a></h3>
            <p class="price">Brand &mdash; <%= med.getMedicineBrand() %></p>
            <p class="price">Rs. <%= med.getMedicinePrice() %></p>
           <%if(admin!=null && user==null) {%>
			
			<a href="MedicineServlet?action=delete&medid=<%= med.getMedicineId() %>">Delete</a>
			<a href="MedicineServlet?action=update&medid=<%= med.getMedicineId() %>">Update</a>
			
			<%} %>
			
			<%if(admin==null && user!=null) 
				{
				if(med.getMedicineQty()<=0)
				{
			%>
				<a href="" onclick="return false";><strike>Add To Cart </strike><b style="color:red"> Out Of Stock</b></a>
			<%} else { %>
				<a href="CartServlet?action=addtocart&medid=<%= med.getMedicineId() %>">Add To Cart</a>
			<%}} %>
          </div>
          <%} %>
          </div>	
   <%-- this part is for display medicinelist table 	
	<div>
        <div class="row mb-5">
          <div class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <th>Medicine Id</th>
					<th>Medicine Name</th>
					<th>Medicine Type</th>
					<th>Medicine Brand</th>
					<th>Medicine Description</th>
					<th>Medicine Quantity</th>
					<th>Medicine Manufacture Date</th>
					<th>Medicine Expiry Date</th>
					<th>Medicine Price</th>
					<% if(admin!=null && user==null){ %>
					<th colspan=2>Action</th>
					<%} %>
					
					<% if(admin==null && user!=null){ %>
					<th>Action</th>
					<%} %>
				</tr>
				</thead>
				<tbody>
	<%
		for(Medicine med : medicinelist)
		{
	%>
		<tr>
			<td><h2 class="h5 text-black"><%= med.getMedicineId() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMedicineName() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMedicineType() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMedicineBrand() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMedicineDescription() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMedicineQty() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMfgDate() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getExpiryDate() %></h2></td>
			<td><h2 class="h5 text-black"><%= med.getMedicinePrice() %></h2></td>
			
			<%if(admin!=null && user==null) {%>
			
			<td><a href="MedicineServlet?action=delete&medid=<%= med.getMedicineId() %>">Delete</a></td>
			<td><a href="MedicineServlet?action=update&medid=<%= med.getMedicineId() %>">Update</a></td>
			
			<%} %>
			
			<%if(admin==null && user!=null) {%>
			
			<td><a href="CartServlet?action=addtocart&medid=<%= med.getMedicineId() %>">Add To Cart</a></td>
			
			<%} %>
		
		
		<%} %>
		</tbody>
		</table>
		</div>
		</div>
		</div>
		</div> --%>
		</form>
		
		<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>