<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Medicine</title>
<style>
	b
	{
		color:red;
	}
</style>
<script type="text/javascript"></script>
<script>
	function validate()
	{
		var medicinename,medicinetype,medicinebrand,medicinedescription,medicineqty,manufacturedate,expirydate,medicineprice
		
		medicinename=document.getElementById("medname").value
		medicinetype=document.getElementById("medtype").value
		medicinebrand=document.getElementById("medbrand").value
		medicinedescription=document.getElementById("meddescription").value
		medicineqty=document.getElementById("medqty").value
		manufacturedate=document.getElementById("mfgdate").value
		expirydate=document.getElementById("expirydate").value
		medicineprice=document.getElementById("medprice").value
				
		if(medicinename=="")
		{
			document.getElementById("mednameerr").innerHTML=" *Required Field"
			return false;
		}
		
		if(medicinetype == "--Select--")
		{
			document.getElementById("medtypeerr").innerHTML=" *Required Field"
			return false;
		}
		
		if(medicinebrand=="")
		{
			document.getElementById("mebranderr").innerHTML=" *Required Field"
			return false;
		}
		
		if(medicinedescription=="")
		{
			document.getElementById("meddescriptionerr").innerHTML=" *Required Field"	
			return false;
		}
		
		if(medicineqty=="")
		{
			document.getElementById("medqtyerr").innerHTML=" *Required Field"	
			return false;
		}
		
		if(manufacturedate=="")
		{
			document.getElementById("mfgdateerr").innerHTML=" *Required Field"	
			return false;
		}
		
		if(expirydate=="")
		{
			document.getElementById("expirydateerr").innerHTML=" *Required Field"	
			return false;
		}
		
		if(new Date(manufacturedate) > new Date(expirydate))
		{
			document.getElementById("expirydateerr").innerHTML=" * Incorrect Expiry Date"	
			return false;
		}
		
		if(medicineprice=="")
		{
			document.getElementById("medpriceerr").innerHTML=" *Required Field"
			return false;
		}
		
		if(isNaN(medicineprice))
		{
			document.getElementById("medpriceerr").innerHTML=" *No Characters Allowed !!!"
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
	
	<jsp:include page="Header.jsp"></jsp:include><!-- For adding header on AddMedicine form -->
	
	<form action="MedicineServlet"  method="post" onsubmit="return validate()" enctype="multipart/form-data"><!-- enctype="multipart/form-data" for image adding -->
	<input type="hidden" name="action" value="add">
	
		<div class="site-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h2 class="h3 mb-5 text-black">Add Medicine</h2>
					</div>
		
          <div class="col-md-12">
          
             <div class="p-3 p-lg-5 border">
             
                  <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Name : </label>
                    <input type="text" class="form-control" name="medname" id="medname" onblur="clearup(this)"><b id="mednameerr"></b>
                  </div>
                </div>
                  
                  <div class="form-group row">
                  <div class="col-md-12">
                   <label for="c_email" class="text-black">Medicine Type : <span class="text-danger">*</span></label>
                   <select name="medtype" id="medtype" onblur="clearup(this)" class="form-control">
							<option selected disabled>--Select--</option>
							<option>Tablet</option>
							<option>Ointment</option>
							<option>Inhaler</option>
							<option>Syrup</option>
							</select><b id="medtypeerr"></b>
                  </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Brand : </label>
                    <input type="text" class="form-control" name="medbrand" id="medbrand" onblur="clearup(this)"><b id="mebranderr"></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_message" class="text-black">Medicine Description : </label>
                    <textarea name="meddescription" id="meddescription" cols="30" rows="7" onblur="clearup(this)" class="form-control"></textarea><b id="meddescriptionerr"></b>
                  </div>
                </div>
                
                 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Quantity : </label>
                    <input type="number" class="form-control" name="medqty" id="medqty" onblur="clearup(this)"><b id="medqtyerr" ></b>
                  </div>
                </div>
     
				<div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Manufacture Date :  </label>
                    <input type="date" class="form-control" name="mfgdate" id="mfgdate" onblur="clearup(this)"><b id="mfgdateerr" ></b>
                  </div>
                </div>
				                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Expiry Date :   </label>
                    <input type="date" class="form-control" name="expirydate" id="expirydate" onblur="clearup(this)"><b id="expirydateerr" ></b>
                  </div>
                </div>
				
				 <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Price :  </label>
                    <input type="text" class="form-control" name="medprice" id="medprice"  onblur="clearup(this)"><b id="medpriceerr"></b>          
                 </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_subject" class="text-black">Medicine Image :  </label>
                    <input type="file" class="form-control" name="medimage" id="medimage"  onblur="clearup(this)"><b id="medimageerr"></b>          
                 </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Add Medicine">
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
	
	<jsp:include page="Footer.jsp"></jsp:include><!-- For adding header on AddMedicine form -->
	
</body>
</html>