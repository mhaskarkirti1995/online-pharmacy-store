<%@page import="com.pharmacy.dao.MedicineDao"%>
<%@page import="com.pharmacy.dao.MedicineDaoImpl"%>
<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="com.pharmacy.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CartList</title>
<script src="jquery-3.5.1.js"></script>
<script>
	//this function is used for calculating total bill when we are changing qty in cart 
	function totalbill()
	{
		var medQuantity = $(".qty");
		var medPrice = $(".price");
		
		var tbill = 0;
		
		for(var i = 0; i < medQuantity.length ; i++)
		{
			tbill = tbill + (medQuantity[i].value * medPrice[i].value);
		}
		$("#tbill").text("Rs. "+tbill);
	}
	//this function is used for setting qty as one when user tries to make it 0 or leess than 
	$(function()
	{
		$(".qty").click(function()
		{
			var medqty = $(".qty");
			
			for(var i = 0 ; i< medqty.length ; i++)
			{
				if(medqty[i].value <= 0)
				{
					$(".qty").val(1);
				}
				else
				{
					totalbill();
				}
			}
		})
		totalbill();
	});
	
// this function is used for to updating qty from mysql table & medicinelist table
	$(function()
	{
		$(".placeorder").click(function()
		{
				var medicineQuantity = $(".qty").val();
				var cartId = $(".id").html();
				
				$.ajax
				({
					type : 'POST',
					data : {action : "updatequantity", medicineQuantity:medicineQuantity, cartId:cartId},
					url : 'CartServlet',
					success : function(result)
					{
						//alert(result);
					}
				});		
		});	
	});

//THis function is used for total qty available in medicine table
 	 $(function()
	{
		$(".qty").click(function()
		{
			var fq = $(".qty");
			var medicineQuantity= $(".tmqty");

			for(var i=0 ; i<fq.length ; i++)
			{
				if(+fq[i].value > + medicineQuantity[i].value)
				{
					fq[i].value = 	medicineQuantity[i].value;
					alert("Only " + medicineQuantity[i].value + " quantity is available for this product.")
				}
				else
				{
					totalbill();
				}
			}
		});
		totalbill();
	});
 //this function is used for updating cart qty if we are already selected any item it will just update qty 	
 	$(document).ready(function()
 	{
 		$(".qty").click(function()
 		{
 			var fq=$(".qty");
 			var id=$(".id");
 			for(var i=0 ; i<fq.length;i++)
 			{
 				if(+fq[i].value>=1)
 				{
 					$.ajax
 					({
 						type:'GET',
 						data:{cartmqty:fq[i].value,cartid:id[i].value,action:"update"},
 						url:'CartServlet',
 						success:function(result)
 						{
 							
 						}
 					});
 				}
 			}
 		});		
 	});
 </script>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<% List<Cart> clist=(List<Cart>)session.getAttribute("cartlist"); 	%>
	
	<form action="OrderServlet" method="post">
	
	<input type="hidden" name="action" value="placeorder">
  				
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Cart List</strong>
          </div>
        </div>
      </div>
    </div>
    
  	<%
		String status=(String)request.getAttribute("status");
		if(status!=null)
			out.print(" <h3 id='a'> "+ status+" !!!");
	%>
  
  	<div>
        <div class="row mb-5">
          <div class="col-md-12">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <tr id="b">	
						<th>Cart Id</th>
						<th>Medicine Id</th>
						<th>Medicine Name</th> 
						<th>Medicine Quantity</th>
						<th>Medicine Price</th>
						<th>Action</th>
					</tr>
				</thead>
		<%
			for(Cart cart:clist)
			{
				Medicine medicine;
				MedicineDao mdao = new MedicineDaoImpl();
				medicine = mdao.searchMedicineById(cart.getMedicineId()); 
				
		%>
		
		<tr>
			<td><h2 class="h5 text-black id"><%= cart.getCartId() %></h2></td>
			<td><h2 class="h5 text-black"><%= cart.getMedicineId() %></h2></td>
			<td><h2 class="h5 text-black"><%= cart.getMedicineName() %></h2></td>
			
			<td><input type="number" class="form-control qty" name="medqty" id="medqty" value="<%= cart.getMedicineQty() %>">
	 			<input type="hidden" class="tmqty" value="<%= medicine.getMedicineQty() %>">
			</td>
			
			<td><input type="text" class="form-control price" name="medprice" value="<%= cart.getMedicinePrice() %>" readonly></td>
			
			<td><h2 class="h5 text-black">
			<a href="CartServlet?action=delete&cartid=<%=cart.getCartId() %>">Delete</a></h2>
			</td>	
			
		</tr>
		<%
			}
		%>
	<tr>
		<td colspan="4">
			<h2 class="h5 text-black">Total :</h2>
		</td>
		<td colspan="2">
			<h2 class="h5 text-black" id="tbill"></h2>
		</td>
	</tr>
		</table>
		</div>
		</div>
		</div>
		</div>
		 <div class="form-group row">
               <div class="col-lg-12">
                   <input type="submit" class="btn btn-primary btn-lg btn-block placeorder" value="PlaceOrder">
                </div>
         </div>
		</form>		
		<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>