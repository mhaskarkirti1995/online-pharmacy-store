<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
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
			if(data[3].value.length != 10)
			{
				data[3].nextElementSibling.innerHTML=" *Please Enter The Correct Contact Number"
				data[3].nextElementSibling.style.color="red"
				count++;
			}
			if(data[2].value.length < 8)
			{
				data[2].nextElementSibling.innerHTML=" *Password length should be 8 or greater than 8"
				data[2].nextElementSibling.style.color="red"
				count++;
			}
			if(!pattern1.test(data[2].value) || !pattern2.test(data[2].value) || !pattern3.test(data[2].value) || !pattern4.test(data[2].value) )
			{
				data[2].nextElementSibling.innerHTML=" *Password should contain the combination of digit,lower,upper,special character"
				data[2].nextElementSibling.style.color="red"
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
<script src="jquery-3.5.1.js"></script>
<script> /* jSon and ajax*/
	$(document).ready(function()
	{
		$("#custemailid").change(function()
		{
			var custemailid=$("#custemailid").val();
			$.ajax
			({
				type:'GET',		 //get is by default 
				data:{name:"checkemailid",custemailid:custemailid},
				url:'CustomerServlet',
				success : function(result)
				{
					$("#custemailiderr").html(result);
				}
			});
		});	
		
		$("#custcontactno").change(function()
		{
			var custcontactno=$("#custcontactno").val();//val method is used to store that variable
			$.ajax //method of ajax
			({
				type:'GET',		 //get is by default 
				data:{name:"checkcustcontactno",custcontactno:custcontactno},//for setting data 
				url:'CustomerServlet',//for checking values like (contact no already present or not) using ajax
				success : function(result)
				{
					$("#custcontactnoerr").html(result);//displaying error msg
				}
			});
		});			
		
		$("#custpassword").change(function()
		{
			var custpassword=$("#custpassword").val();
			$.ajax
			({
				type:'GET',
				data:{name:"checkcustpassword",custpassword:custpassword},
				url:'CustomerServlet',
				success:function(result)
				{
					$("#custpassworderr").html(result);
				}
			});
		});
	});
	
	
</script>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include><!-- For adding header on form -->
	<div>
		<%	String status=(String)request.getAttribute("status");
			
		 	if(status!=null)
				out.print("<h3 id='a'> " +status+ " !!!");
		%>
	</div>
<!-- 	<div><b>Please <a href="Login.jsp">Sign In </a> to Continue</b></div> -->
	<form action="CustomerServlet" method="post" onsubmit="return validate()">
	<input type="hidden" name="action" value="add">
	
	<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Registration</h2>
					</div>
					
          <div class="col-md-12">
          
             <div class="p-3 p-lg-5 border">
             
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Name : <span class="text-danger">*</span></label>
                    <input type="text" class="form-control demo" name="custname" id="custname"  onblur="clearup(this)"><b></b>
                  </div>
                </div>
		
				 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Email Id : <span class="text-danger">*</span></label>
                    <input type="email" class="form-control demo" name="custemailid" id="custemailid" onblur="clearup(this)"><b id="custemailiderr"></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Customer Password  : <span class="text-danger">*</span></label>
                    <input type="password" class="form-control demo" name="custpassword" id="custpassword"  onblur="clearup(this)"><b id="custpassworderr"></b>
                  </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Contact Number  : <span class="text-danger">*</span></label>
                    <input type="number" class="form-control demo" name="custcontactno"  id="custcontactno" onblur="clearup(this)"><b id="custcontactnoerr"></b>
                  </div>
                </div>
      
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Customer Address :<span class="text-danger">*</span> </label>
                    <textarea name="custaddress" id="custaddress" cols="30" rows="7" onblur="clearup(this)" class="form-control demo"></textarea><b></b>
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
	<jsp:include page="Footer.jsp"></jsp:include><!-- For adding header on AddMedicine form -->
</body>
</html>