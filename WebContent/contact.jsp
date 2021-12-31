<%@page import="com.pharmacy.pojo.Customer"%>
<%@page import="com.pharmacy.pojo.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Contact</title>
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
<script>
	function validate()
	{
		firstname=document.getElementById("fname").value
		lastname=document.getElementById("lname").value
		email=document.getElementById("email").value
		subject=document.getElementById("subject").value
		message=document.getElementById("message").value
		
		if(firstname=="")
		{
			document.getElementById("fnameerr").innerHTML=" *Required Field"
			return false;
		}
		if(lastname=="")
		{
			document.getElementById("lnameerr").innerHTML=" *Required Field"
			return false;
		}
		if(email=="")
		{
			document.getElementById("emailerr").innerHTML=" *Required Field"
			return false;
		}
		if(subject=="")
		{
			document.getElementById("suberr").innerHTML=" *Required Field"
			return false;
		}
		if(message=="")
		{
			document.getElementById("msgerr").innerHTML=" *Required Field"
			return false;
		}
		return true;
	}
	function clearup(data)//for clear validation once validation done
	{
		if(data.value!="")
		{
			data.nextElementSibling.innerHTML="";
		}
	}
	
</script>
</head>

<body>

	<jsp:include page="Header.jsp"></jsp:include>
	<% Customer customer=(Customer)session.getAttribute("cust"); %>	
    
    <div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span>
            <strong class="text-black">Contact</strong>
          </div>
        </div>
      </div>
    </div>
    <div >
    
	<%
		String status= (String)request.getAttribute("status");
		if(status!=null)
			out.print(" <h3 id='a'> "+ status+" !!!");
		
		String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
	%>
	</div>
    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Get In Touch</h2>
          </div>
          <div class="col-md-12">
    
            <form action="ContactServlet" onsubmit="return validate()" method="post">
    
              <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="fname" name="fname" onblur="clearup(this)"><b id="fnameerr"></b>
                  </div>
                  <div class="col-md-6">
                    <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="lname" name="lname" onblur="clearup(this)"><b id="lnameerr"></b>
                  </div>
                </div>
                <%if(admin==null && user!=null) 
				{ %>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_email" class="text-black">Email <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="emailid" placeholder="" value="<%= customer.getCustomerEmailId() %>" readonly onblur="clearup(this)"><b id="emailerr"></b>
                  </div>
                </div>
                <%} %>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Subject <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="subject" name="subject" onblur="clearup(this)"><b id="suberr"></b>
                  </div>
                </div>
    
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Message <span class="text-danger">*</span></label>
                    <textarea name="message" id="message" cols="30" rows="7" class="form-control" onblur="clearup(this)"></textarea><b id="msgerr"></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Send Message">
                  </div>
                </div>
              </div>
            </form>
          </div>
          </div>
      </div>
    </div>



    <div class="site-section bg-primary">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <h2 class="text-white mb-4">Offices</h2>
          </div>
          <div class="col-lg-4">
            <div class="p-4 bg-white mb-3 rounded">
              <span class="d-block text-black h6 text-uppercase">Mumbai</span>
              <p class="mb-0">125, Kalyan Bhavan, Charni Road, Jss Rd, Girgaon, Mumbai,
              						 Maharashtra 400004
            	</p>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="p-4 bg-white mb-3 rounded">
              <span class="d-block text-black h6 text-uppercase">Navi Mumbai</span>
              <p class="mb-0"> 814, Someshwar Mandir Marg, Sector 1, Shiravane, Nerul, Navi Mumbai,
               Maharashtra 400709			</p>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="p-4 bg-white mb-3 rounded">
              <span class="d-block text-black h6 text-uppercase">Pune</span>
              <p class="mb-0">203 Jijau Masaheb Marg, Prashant Society, Gururaj Society, Kothrud, Pune, Maharashtra 411038
				</p>
            </div>
          </div>
        </div>
      </div>
      
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>