<%@page import="com.pharmacy.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.pharmacy.dao.CartDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Pharma</title>
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
  
	<style> /* for giving color to messages like item has been added  */
		#a
		{
			color:red;
		}
		a:hover
		{
			background-color:yellow; 
		}
		a:visited
	   {
  			color: red;
  			background-color: transparent;
  			text-decoration: none;
	   }
		
	</style>
		
</head>

<body>

	<%
		String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
		
		//to get the length of the cart list
		CartDaoImpl cdao=new CartDaoImpl();
		List<Cart> cartlist=cdao.showCart(user);
		int length=cartlist.size();
	%>
	
  <div class="site-wrap">
    <div class="site-navbar py-2">

      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
           <%if((admin==null && user==null)||(admin==null && user!=null)) {%>
          <form action="MedicineServlet"><!-- for search item by name and brand -->
            <input type="text" class="form-control" name="medname" placeholder="Search keyword and hit enter...">
            <input type="hidden" name="action" value="search">
            <%} %>
            </form>
            <%if(admin!=null && user==null) {%>
            <form action="OrderServlet"><!-- for admin search order in order list by cust email id  -->
            <input type="text" class="form-control" name="custemailid" placeholder="Search keyword and hit enter...">
            <input type="hidden" name="action" value="searchorder">
            <%} %>
          </form>
        </div>
      </div>

      <div style="background-color: #33F9FF">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="Index.jsp" class="js-logo-clone">Pharma</a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
           
           <!-- this part only for visiting user  -->  
             <% if(user==null && admin==null){ %>
             
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="active"><a href="Index.jsp">Home</a></li>
                <li><a href="MedicineServlet">Store</a></li>
                <li><a href="AddCustomer.jsp">Sign Up</a></li>
				<li><a href="Login.jsp">Sign In</a></li>
                <li><a href="about.jsp">About Us</a></li>
             <!--    <li><a href="contact.jsp">Contact</a></li> -->
              </ul>
              <% } %>
              
                <!-- this part for Admin  -->  
               <% if(user==null && admin!=null){ %>
             
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="active"><a href="Index.jsp">Home</a></li>
                <li><a href="MedicineServlet">Store</a></li>
               	<li><a href="AddMedicine.jsp">Add Medicine</a></li>
               	<li><a href="CustomerServlet">Customer List</a></li>
               	<li><a href="FeedbackServlet">Feedback List</a></li>
               	<li><a href="OrderServlet?action=showallorders">Order List</a></li>
               	<li><a href="ContactServlet?action=contactlist">Contact List</a></li>
               	<li><a href="about.jsp">About Us</a></li>
                <li><a href="LoginServlet">Log Out</a></li>
              </ul>
              <% } %>
              
                 <!-- this part for User  -->  
               <% if(user!=null && admin==null){ %>
             
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="active"><a href="Index.jsp">Home</a></li>
                <li><a href="MedicineServlet">Store</a></li>
               	<li><a href="CustomerServlet?action=update&custemailid=<%= user%>">Edit Profile</a></li>
               	<li><a href="AddFeedback.jsp?action=update&custemailid=<%= user%>">Feedback</a></li><!-- when I click on feedback i want custemail id which use has been login-->
               	<li><a href="OrderServlet?action=myorders&custemailid=<%= user%>">My Orders</a></li>
               	<li><a href="about.jsp">About Us</a></li>
                <li><a href="contact.jsp?action=update&custemailid=<%= user%>">Contact</a></li>
                <li><a href="LoginServlet">Log Out</a></li>
              </ul>
              <% } %>
              
              <%if(user!=null && admin!=null){ %>
             	<ul>
              	 <li><a href="LoginServlet">Log Out</a></li>
              	</ul>
              <%}%>
              
            </nav>
          </div>
          <div class="icons">
            <a href="" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
         	<% if(user!=null && admin==null){%>
            <a href="CartServlet" class="icons-btn d-inline-block bag">
              <span class="icon-shopping-bag"></span>
              <span class="number"><%= length %></span>
            </a>
            <%} %>
            <a href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
                class="icon-menu"></span></a>
          </div>
        </div>
      </div>
    </div>
    
   </div>
   </body>
   </html>
   
   
    <!--   <li class="has-children">
                  <a href="#">Dropdown</a>
                  <ul class="dropdown">
                    <li><a href="#">Supplements</a></li>
                    <li class="has-children">
                      <a href="#">Vitamins</a>
                      <ul class="dropdown">
                        <li><a href="#">Supplements</a></li>
                        <li><a href="#">Vitamins</a></li>
                        <li><a href="#">Diet &amp; Nutrition</a></li>
                        <li><a href="#">Tea &amp; Coffee</a></li>
                      </ul>
                    </li>
                    <li><a href="#">Diet &amp; Nutrition</a></li>
                    <li><a href="#">Tea &amp; Coffee</a></li>
                    
                  </ul>
                </li>
                -->
              