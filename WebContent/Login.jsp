<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="jquery-3.5.1.js"></script>
	<script src="jquery.validate.min.js"></script>
	<!-- JQuery validations 
	 <script >
	
		$(function(){
			$("form").validate
			({
				rules :
					{
						type : {required : true},
						uname : {required : true},
						pass : 
							{
								required : true,
								minlength :8,
								maxlength : 16
							}
					}
			})
		})
		</script>
		 -->
	<script>
	function validate()
	{
		var type,username,password;
		
		type=document.getElementById("type").value
		username=document.getElementById("uname").value
		password=document.getElementById("pass").value
		
		if(type == "--select--")
		{
			document.getElementById("typeerr").innerHTML=" *Required Field"
			return false;
		}
		if(username =="")
		{
			document.getElementById("unameerr").innerHTML=" *Required Field"
			return false;
		}
		if(password =="")
		{
			document.getElementById("passerr").innerHTML=" *Required Field"
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
			if(x.type ==="password")
				{
					x.type = "text";
				}
			else
				{
					x.type = "password"
				}
		}
		
	</script>
	
<title>Login</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>	
	
	<form action="LoginServlet" onsubmit="return validate()" method="post">
	<input type="hidden" name="action" value="login">
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
						<h2 class="h3 mb-5 text-black">Login</h2>
					</div>
					
		 <div class="col-md-12">
         <div class="p-3 p-lg-5 border">
        
					
		<div class="form-group row">
             <div class="col-md-12">
                <label for="c_subject" class="text-black">Type : <span class="text-danger">*</span></label>
                   <select name="type" id="type" onblur="clearup(this)" class="form-control">
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
                 <label for="c_subject" class="text-black">Password : <span class="text-danger">*</span></label>
                 <input type="password" class="form-control" name="pass" id="pass" onblur="clearup(this)"><b id="passerr"></b>
               </div>
          </div>
		
		<div class="form-group row">
              <div class="col-md-12">
                 <input type="checkbox"  name="showpass" id="showpass" onclick="myFunction()"><b></b>
                 <label for="c_subject" class="text-black">Show Password  </label>
               </div>
          </div>
	
		<div class="form-group row">
              <div class="col-md-12">
                 <label for="c_subject" class="text-black"><h3>New User : </h3></label>
                 <label><h3><a href="AddCustomer.jsp"> Not registered yet? Register Now</a></h3></label>
                <label><h3><a href="ChangePassword.jsp">Forgot Password</a></h3></label>
             </div>
        </div>
          
          <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Login">
                  </div>
                  <div class="col-lg-6">
                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Cancel">
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