<%@page import="com.pharmacy.pojo.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback List</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	
	<div class="bg-light py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mb-0">
            <a href="Index.jsp">Home</a> <span class="mx-2 mb-0">/</span> 
            <strong class="text-black">Feedback List</strong>
          </div>
        </div>
      </div>
    </div>
	<% List<Feedback> feedbacklist=(List<Feedback>)session.getAttribute("feedlist"); %>
	
	<div>
        <div class="row mb-5">
          <form class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr id="b">
                    <tr id="b">	
						<th>Feedback Id</th>
						<th>Customer Email Id</th>
						<th>Rate Medicine</th>
						<th>Suggestion</th>
					</tr>
				</thead>
	<tbody>
	<% for(Feedback feed : feedbacklist) { %>
	
	<tr>
		<td><h2 class="h5 text-black"><%=feed.getFeedbackId() %></h2></td>
		<td><h2 class="h5 text-black"><%=feed.getCustomerEmailId() %></h2></td>
		<td><h2 class="h5 text-black"><%=feed.getRateMedicine() %></h2></td>
		<td><h2 class="h5 text-black"><%=feed.getSuggestion() %></h2></td>
	</tr>
	
	<% } %>
	
	</tbody>
	</table>
	</div>
	</form>
	</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>