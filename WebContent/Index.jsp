<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Online Pharmacy Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
  <link rel="stylesheet" href="fonts/icomoon/style.css">

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/magnific-popup.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <link rel="stylesheet" href="css/owl.theme.default.min.css">


  <link rel="stylesheet" href="css/aos.css">

  <link rel="stylesheet" href="css/style.css">

</head>

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<%
		List<Medicine> medicinelist=(List<Medicine>)session.getAttribute("medlist");
	%>
 	<% 	
		String status=(String)request.getAttribute("status");
	
		if(status!=null )
			out.print("<h3 id='a'> "+status+" !!!");
		
		String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
	%> 
	
	<div class="site-blocks-cover" style="background-image: url('images/hero_1.jpg');">
      <div class="container">
        <div class="row">
          <div class="col-lg-7 mx-auto order-lg-2 align-self-center">
            <div class="site-block-cover-content text-center">
              <h2 class="sub-title">Effective Medicine, New Medicine Everyday</h2>
              <h1>Welcome To Pharma</h1>
              <p>
                <a href="MedicineList.jsp" class="btn btn-primary px-5 py-3">Shop Now</a>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row align-items-stretch section-overlap">
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="banner-wrap bg-primary h-100">
              <a href="MedicineList.jsp" class="h-100">
                <h5>Free <br> Shipping</h5>
                <p>
                  <strong></strong>
                </p>
              </a>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="banner-wrap h-100">
              <a href="MedicineList.jsp" class="h-100">
                <h5>Season <br> Sale 50% Off</h5>
                <p>
                  
                  <strong></strong>
                </p>
              </a>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
            <div class="banner-wrap bg-warning h-100">
              <a href="MedicineList.jsp" class="h-100">
                <h5>Buy <br> A Gift Card</h5>
                <p>
                  <strong></strong>
                </p>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="title-section text-center col-12">
            <h2 class="text-uppercase">Popular Products</h2>
          </div>
        </div>
        
        <div class="row">
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <span class="tag">Sale</span>
            <a href="MedicineList.jsp"> <img src="imagespharmacy/crocin.jpg" alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineList.jsp">Crocin</a></h3>
            <p class="price"><del>95.00</del> &mdash; 55.00</p>
          </div>
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
           <a href="MedicineList.jsp"> <img src="imagespharmacy/asthalin-inhaler.png" alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineList.jsp">Asthalin Inhaler</a></h3>
            <p class="price">270.00</p>
          </div>
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
           <a href="MedicineList.jsp"> <img src="imagespharmacy/asthalin syrup.jpg" alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineList.jsp">Asthalin Syrup</a></h3>
            <p class="price">230.00</p>
          </div>

          <div class="col-sm-6 col-lg-4 text-center item mb-4">
           <a href="MedicineList.jsp"> <img src="imagespharmacy/duolin-inhaler.jpg" alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineList.jsp">Duolin Inhaler</a></h3>
            <p class="price">400.00</p>
          </div>
          
         <div class="col-sm-6 col-lg-4 text-center item mb-4">
           <a href="MedicineList.jsp"> <img src="imagespharmacy/vicksAction500.jpg" alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineList.jsp">Advanced VicksAction500</a></h3>
            <p class="price">100.00</p>
          </div>
          
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
           <a href="MedicineList.jsp"> <img src="imagespharmacy/crocin1.jpg" alt="Image" height="350" width="300"></a>
            <h3 class="text-dark"><a href="MedicineList.jsp">Crocin Pain Relief</a></h3>
            <p class="price">150.00</p>
          </div>
        </div>
        <div class="row mt-5">
          <div class="col-12 text-center">
            <a href="MedicineList.jsp" class="btn btn-primary px-4 py-3">View All Products</a>
          </div>
        </div>
      </div>
    </div>
        

       <%-- <div class="row">
    	<%
			for(Medicine med : medicinelist)
			{
		%>
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <a href="MedicineServlet?action=details&medid=<%= med.getMedicineId()%>"> <img src="ImageController?medid=<%=med.getMedicineId() %>" alt="Image"></a>
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
		</div>
		</div> --%>

    
    <div class="site-section bg-light">
      <div class="container">
        <div class="row">
          <div class="title-section text-center col-12">
            <h2 class="text-uppercase">New Products</h2>
          </div>
        </div>
         <div class="row">
          <div class="col-md-12 block-3 products-wrap">
            <div class="nonloop-block-3 owl-carousel">
		
			<%-- <%
			for(Medicine med : medicinelist)
			{
			%>
              <div class="text-center item mb-4">
                <a href="MedicineServlet?action=details&medid=<%= med.getMedicineId()%>"> <img src="ImageController?medid=<%=med.getMedicineId() %>" alt="Image"></a>
                 <h3 class="text-dark"><a href="MedicineServlet?action=details&medid=<%= med.getMedicineId()%>"><%= med.getMedicineName() %></a></h3>
                <p class="price">Rs. <%= med.getMedicinePrice() %></p>
              </div>
              
			<%} %> --%>
               <div class="text-center item mb-4">
                <a href="MedicineList.jsp"> <img src="imagespharmacy/dylotop-painkiller.jpg" alt="Image" height="350" width="300"></a>
                <h3 class="text-dark"><a href="MedicineList.jsp">Dylotop</a></h3>
                <p class="price">200.00</p>
              </div>

              <div class="text-center item mb-4">
                <a href="MedicineList.jsp"> <img src="imagespharmacy/tablets.jpg" alt="Image" height="350" width="300"></a>
                <h3 class="text-dark"><a href="MedicineList.jsp">Saridon</a></h3>
                <p class="price">50.00</p>
              </div>

              <div class="text-center item mb-4">
                <a href="MedicineList.jsp"> <img src="imagespharmacy/Vicks_Inhaler.png" alt="Image" height="350" width="300"></a>
                <h3 class="text-dark"><a href="MedicineList.jsp">Vicks Inhaler</a></h3>
                <p class="price">100.00</p>
              </div>
              
            </div>
          </div>
        </div>
      </div>
    </div>

	<jsp:include page="Footer.jsp"></jsp:include>
   </body>

</html>