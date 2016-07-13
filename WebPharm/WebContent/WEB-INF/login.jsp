<%@page import="enums.PersonRole"%> 
<%@page import="utils.Constants"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>





 <script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
 
        
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 

	<script type="text/javascript" src="js/login.js"></script>
	
</head>

   <!--  <link rel="stylesheet" type="text/css" href="css/style1.css"/>
    --> 


<body>


<div class="container">
  <h1>Login or </h1>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" id="login" data-target="#myModal">Log in</button>
      <button type="button" class="btn btn-info btn-lg" data-toggle="modal" id="logout">Log Out</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Login Form</h4>
        </div>
        <div class="modal-body">
          <form name="form" id="form" class="form-horizontal" enctype="multipart/form-data" method="POST" >
                   
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="user" type="text" class="form-control" name="user" value="" placeholder="User">                                        
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                    </div>                                                                  

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-sm-12 controls">
                                                  
                        </div>
                    </div>
     <div class="modal-footer">
             <button type="submit" class="btn btn-primary "><i class="glyphicon glyphicon-log-in"></i> Log in</button>   
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
                </form>     
        </div>
   
      </div>
      
    </div>
  </div>
  
</div>


	
</body>
</html>