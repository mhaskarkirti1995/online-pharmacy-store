<%@page import="com.pharmacy.pojo.Customer"%>
<%@page import="com.pharmacy.pojo.Medicine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>
	<script>
		/*Jquery validations 
		$(function()
		{
			$("form").validate
			({
				rules : 
				{
					custid : { required : true},
					custname : {required : true},
					custemailid : {required : true},
					custpass : 
					{
						required : true,
						minlength : 8,
						maxlength : 16
					},
					custcontact :
					{
						required : true,
						minlength : 10,
						maxlength : 10
					},
					
					custaddress : {required : true}
					
				}
			})	
		}) */
		
	</script>
<script>
function validate()
{
	//Regular Expression
	pattern1 = /[0-9]/
	pattern2 = /[a-z]/
	pattern3 = /[A-Z]/
	pattern4 = /[! @ # $ % ^ & *]/

	data = document.getElementsByClassName("demo");
	count = 0
	for(var i=0;i<data.length;i++)
	{
		
		if(data[i].value=="")
		{
			data[i].nextElementSibling.innerHTML=" *Required Field"
			data[i].nextElementSibling.style.color="red"
			count++;
		}
		if((data[4].value.length != 10 ) || (data[4].value.length >10 ))
		{
			data[4].nextElementSibling.innerHTML=" *Please Enter The Correct Contact Number"
			data[4].nextElementSibling.style.color="red"
			count++;
		}
		if(data[3].value.length < 8)
		{
			data[3].nextElementSibling.innerHTML=" *Password length should be 8 or greater than 8"
			data[3].nextElementSibling.style.color="red"
			count++;
		}
		if(!pattern1.test(data[3].value) || !pattern2.test(data[3].value) || !pattern3.test(data[3].value) || !pattern4.test(data[2].value) )
		{
			data[3].nextElementSibling.innerHTML=" *Password should contain the combination of digit,lower,upper,special charater"
			data[3].nextElementSibling.style.color="red"
			count++;
		}
	}
	
	if(count>0)
		return false
	else
		return true		
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
  
	<form action="CustomerServlet" onsubmit="return validate()" method="post">
	<input type="hidden" name="action" value="update">
	
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Update Customer</h2>
					</div>
		
          <div class="col-md-12">
          
             <div class="p-3 p-lg-5 border">
             
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer ID  : </label>
                    <input type="number" class="form-control demo" name="custid" id="custid" value="<%= customer.getCustomerId() %>" readonly>
                  </div>
                </div>
                
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Name : <span class="text-danger">*</span></label>
                    <input type="text" class="form-control demo" name="custname" id="custname" value="<%= customer.getCustomerName() %>" onblur="clearup(this)"><b></b>
                  </div>
                </div>
		
				 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Email Id : <span class="text-danger">*</span></label>
                    <input type="email" class="form-control demo" name="custemailid" id="custemail" value="<%= customer.getCustomerEmailId() %>" onblur="clearup(this)"><b id="custemailiderr"></b>
                  </div>
                </div>
                
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Password  : <span class="text-danger">*</span></label>
                    <input type="password" class="form-control demo" name="custpass" id="custemail" value="<%= customer.getCustomerPassword() %>" onblur="clearup(this)"><b id="custpassworderr" ></b>
                  </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Contact Number  : <span class="text-danger">*</span></label>
                    <input type="number" class="form-control demo" name="custcontact" id="contact" class="demo" value="<%= customer.getContactNumber()%>" onblur="clearup(this)"><b id="custcontacterr"></b>
                  </div>
                </div>
            
            
               <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Customer Address :<span class="text-danger">*</span> </label>
                    <textarea name="custaddress" id="custaddress" cols="30" rows="7" class="form-control demo" onblur="clearup(this)"><%= customer.getCustomerAddress() %></textarea><b id="custadderr" ></b>
                  </div>
                </div>
      	
      			 <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Update">
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