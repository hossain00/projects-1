<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement</title>
<!-- Bootstap -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	<!-- Custom Style -->
	<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	
<div class="container">

    
        
       
       <form action="${pageContext.request.contextPath}/secure/addreimb.do" method="post" id= "reimbform" class="form-horizontal" >
       <h2 align="center">Create New Reimbursement</h2>
       
		  
		   <div class="form-group">
		    <label for="reimb_amount" class="col-sm-4 control-label">Reimbursement Amount</label>
		    <div class="col-sm-5">
		      <input type="number" min="0.01" step="0.01" max="10000" class="form-control" id="reimb_amount" name="reimb_amount" placeholder="Amount" required="required" value="${param.reimb_amount }" />
		    </div>
		    
		  </div>
		  <div class="form-group">
		    <label for="reimb_descript" class="col-sm-4 control-label">Description</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="reimb_descript" name="reimb_descript" placeholder="Description" required="required" value="${param.reimb_descript }" />
		    </div>
		  </div>
		  
		  
		 <div class="form-group">
				<label for="reimb_typeid" class="col-sm-4 control-label">Reimbursement
					Type: </label>
				<div class="col-sm-1">
						<select name="reimb_typeid"
						form="reimbform">
						<option value="1">Lodging</option>
						<option value="2">Travel</option>
						<option value="3">Food</option>
						<option value="4">Other</option>
					</select>
				</div>
			</div>
        
     		<div class="form-group">
		    <label for="content" class="col-sm-4 control-label">Receipt</label>
		    <div class="col-sm-5">
		      <input type="file" class="form-control" id="content" name="content" placeholder="Content"  value="${param.content }" />
		    </div>
		  </div>
		 	 
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Create</button>
		    </div>
		  </div>
		</form>	

	  </div>
       
       
    </div>

</body>
</html>