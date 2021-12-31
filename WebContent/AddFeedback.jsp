<%@page import="com.pharmacy.pojo.Customer"%>
<%@page import="com.pharmacy.pojo.Feedback"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Give Feedback</title>
	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	<link rel="stylesheet" href="Star.css"><!-- external css file used for star rating  -->
		<script>
			/*Jquery validations 
			$(function()
			{
				$("form").validate
				({
					rules : 
						{
							custemailid : { required : true },
							ratemed : { required : true },
							rateus : { required : true },
							suggestion : { required : true }
						}
				})
			}) */
		function validate()
		{	
			stars = document.getElementsByName("ratemed");
			check=0
			for(i=0;i<stars.length;i++)
			{
				if(stars[i].checked)
				{
					check=1;
					return true;
				}
			}
			if(check==0)
			{
				document.getElementById("ratemederr").innerHTML = "*Required Field"
				document.getElementById("ratemederr").style.color="red"
				return false;
			}
			if(check>0)
				return false;
			else 
				return true;
		}
		
		function clearup(data)
		{
			if(data.value != "")
				{
					data.nextElementSibling.innerHTML="";
				}
		}
		
		</script>

</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<% Customer customer=(Customer)session.getAttribute("cust"); %>
		
	<form action="FeedbackServlet" onsubmit="return validate()" method="post">
	
   	<input type="hidden" name="action" value="update">
	<div>
	<% String status=(String)request.getAttribute("status");
		if(status!=null)
			out.print("<h3 id='a'>"+status);
		
		String admin=(String)session.getAttribute("admin");
		String user=(String)session.getAttribute("user");
	%>
	</div>
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black"> Give Feedback </h2>
					</div>
			 <%if(admin==null && user!=null) 
				{ %>
			<div class="col-md-12">
					<div class="p-3 p-lg-5 border">
				<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Email Id : <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" name="custemailid" id="custemailid" class="demo" value="<%= customer.getCustomerEmailId() %>" readonly>
                    <b id="custemailiderr"></b>
                  </div>
                </div>
                <%} %>
                
			<div class="form-group row">
                  <div class="col-md-12">
                	  <label for="c_subject" class="text-black" >Rate Medicine : <span class="text-danger">*</span></label>
						 <div class="ratting-wrapper">
							  <input type="radio" name="ratemed" id="star-1" value="5" ><label style="margin-bottom: 4.5rem" for="star-1"></label>
							  <input type="radio" name="ratemed" id="star-2" value="4" ><label style="margin-bottom: 4.5rem" for="star-2"></label>
							  <input type="radio" name="ratemed" id="star-3" value="3" ><label style="margin-bottom: 4.5rem" for="star-3"></label>
							  <input type="radio" name="ratemed" id="star-4" value="2" ><label style="margin-bottom: 4.5rem" for="star-4"></label>
							  <input type="radio" name="ratemed" id="star-5" value="1" onblur="clearup(this)"><label style="margin-bottom: 4.5rem" for="star-5"></label>	 
						</div>
						<b id="ratemederr"></b>
				</div>
			</div>
			
		<!-- 	<div class="form-group row">
                  <div class="col-md-12">
                 	 <label class="text-black">Rate Us : <span class="text-danger">*</span></label>
	                 	 <div class="ratting-wrapper">
							  <input type="radio" name="rateus" id="star-1" value="5" class="demo" onblur="clearup(this)"><label style="margin-bottom: 4.5rem" for="star-1"></label>
							  <input type="radio" name="rateus" id="star-2" value="4" class="demo" onblur="clearup(this)"><label style="margin-bottom: 4.5rem" for="star-2"></label>
							  <input type="radio" name="rateus" id="star-3" value="3" class="demo" onblur="clearup(this)"><label style="margin-bottom: 4.5rem" for="star-3"></label>
							  <input type="radio" name="rateus" id="star-4" value="2" class="demo" onblur="clearup(this)"><label style="margin-bottom: 4.5rem" for="star-4"></label>
							  <input type="radio" name="rateus" id="star-5" value="1" class="demo" onblur="clearup(this)"><label style="margin-bottom: 4.5rem" for="star-5"></label>
							 
						</div>
							<b id="rateuserr"></b>		
				</div>
			</div> 
		 -->	
			<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Suggestion : </label>
                    <textarea name="suggestion" id="suggestion" cols="30" rows="7" onblur="clearup(this)" class="form-control demo"></textarea><b id="suggestionerr"></b>
                  </div>
                </div>
            
            <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Submit">
                  </div>
                  <div class="col-lg-6">
                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Reset">
                  </div>
           </div>
        
		</div>
		</div>
		</div>
		</div>
		</div>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>