<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Notes</title>
    <%@include file="all_js_css.jsp" %>
  </head>
  <body>
    <div class="container-fluid">
    	<%@include file="navbar.jsp"%>
    </div>
    
    <div class="container">
    	<form action="SaveNoteServlet" method="post">
		  <div class="form-group">
		    <label for="title">Title</label>
		    <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp" placeholder="Enter Title" required>
		    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		  </div>
		  <div class="form-group">
		    <label for="content">Content</label>
		    <textarea class="form-control" style="height: 200px;" id="content" name="content" placeholder="Enter Content here" required> </textarea>
		  </div>
		  <div class="text-center"><button type="submit" class="btn btn-primary">Submit</button></div>
		  
		</form>
    </div>


  </body>
</html>