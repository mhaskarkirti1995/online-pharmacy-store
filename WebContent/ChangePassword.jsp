<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Change Password</title>
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>
	<!-- <script>
		$(function()
		{
			$("form").validate
			({
				rules : 
				{
					type : {required : true },
					uname : {required : true},
					password : 
					{
						required : true,
						minlength : 8,
						maxlength : 16
					},
					confirmpass :  
					{
						required : true,
						equalTo : "#pass"
					}
				}
			})	
		}) 
		</script>
		-->
	<script>
		function validate()
		{
				var type,username,newpassword,confirmpassword;
				
				type=document.getElementById("type").value
				username=document.getElementById("uname").value
				newpassword=document.getElementById("pass").value
				confirmpassword=document.getElementById("confirmpass").value
				
				if(type=="--select--")
				{
					document.getElementById("typeerr").innerHTML=" *Required Field"
					return false;
				}
				if(username=="")
				{
					document.getElementById("unameerr").innerHTML=" *Required Field"
					return false;
				}
				if(newpassword=="")
				{
					document.getElementById("newpasserr").innerHTML=" *Required Field"
					return false;
				}
				if(confirmpassword=="")
				{
					document.getElementById("confpasserr").innerHTML=" *Required Field"
					return false;
				}
				if(confirmpassword !=  newpassword)
				{
					document.getElementById("confpasserr").innerHTML=" * Password should same as new password"
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
		
		function myFunction()//this function is used for view password 
		{
			var x = document.getElementById("pass");
			var y = document.getElementById("confirmpass");
			if(x.type ==="password" || y.type==="password")
				{
					x.type = "text";
					y.type= "text" ;
				}
			else
				{
				x.type = "password"
				y.type= "password"
				}
		}
		
</script>
</head>
<body>
		<jsp:include page="Header.jsp"></jsp:include>

	<form action="LoginServlet" onsubmit="return validate()" method="post" >
	<input type="hidden" name="action" value="change">

	<div>
	<%	String status=(String)request.getAttribute("status");
	
	 	if(status!=null)
			out.print("<h3 id='a'> "+status+" !!!"); 
	%>
	</div>
	
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Change Password</h2>
					</div>
					
		 <div class="col-md-12">
         <div class="p-3 p-lg-5 border">
                
        <div class="form-group row">
             <div class="col-md-12">
                <label for="c_subject" class="text-black">Type : <span class="text-danger">*</span></label>
                   <select name="type" id="type" class="form-control" onblur="clearup(this)">
                   <option selected disabled>--select--</option>
                   <option value="admin">Admin</option>
                   <option value="customer">Customer</option>
                   </select><b id="typeerr"></b>
              </div>
         </div>
                
     	<div class="form-group row">
              <div class="col-md-12">
                 <label for="c_subject" class="text-black">User Name : <span class="text-danger">*</span> </label>
                 <input type="text" class="form-control" name="uname" id="uname" onblur="clearup(this)"><b id="unameerr"></b>
               </div>
          </div>
		
		<div class="form-group row">
              <div class="col-md-12">
                 <label for="c_subject" class="text-black">New Password : <span class="text-danger">*</span></label>
                 <input type="password" class="form-control" name="pass" id="pass" onblur="clearup(this)"><b id="newpasserr"></b>
               </div>
          </div>
		
		<div class="form-group row">
              <div class="col-md-12">
                 <label for="c_subject" class="text-black">Confirm Password : <span class="text-danger">*</span></label>
                 <input type="password" class="form-control" name="password" id="confirmpass" onblur="clearup(this)"><b id="confpasserr"></b>
               </div>
          </div>
		
		<div class="form-group row">
              <div class="col-md-12">
                 <input type="checkbox"  name="showpass" id="showpass" onclick="myFunction()"><b></b>
                 <label for="c_subject" class="text-black">Show Password  </label>
               </div>
          </div>
	
		<div class="form-group row">
                <div class="col-lg-6">
                  	 <input type="submit" class="btn btn-primary btn-lg btn-block" value="Change" name="login">
                </div>
                 <div class="col-lg-6">
                  	<input type="reset" class="btn btn-primary btn-lg btn-block" value="Cancel" name="reset">
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