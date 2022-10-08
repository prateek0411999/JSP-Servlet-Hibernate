<!doctype html>
<%@page import="com.noteTaker.entities.Note"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.note.hibernateUtility.HibernateUtility"%>
<%@page import="org.hibernate.SessionFactory"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>NoteTaker</title>
    <%@include file="all_js_css.jsp" %>
  </head>
  <body>
    <div class="container-fluid">
    	<%@include file="navbar.jsp"%>
    </div>
   
    <%
    int note_id = Integer.parseInt(request.getParameter("note_id"));
    SessionFactory factory = HibernateUtility.getSessionFactory();
	Session s = factory.openSession();
	Note note = s.get(Note.class, note_id);
	s.close();
    
    %>
 	<div class="container">
    	<form action="UpdateNoteServlet" method="post">
    	<input type="hidden" name="note_id" value=<%= note.getId() %> />
		  <div class="form-group">
		    <label for="title">Title</label>
		    <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp" value="<%= note.getTitle() %>" required>
		    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		  </div>
		  <div class="form-group">
		    <label for="content">Content</label>
		    <textarea class="form-control" style="height: 200px;" id="content" name="content" required><%= note.getContent() %> </textarea>
		  </div>
		  <div class="text-center"><button type="submit" class="btn btn-primary">Submit</button></div>
		  
		</form>
    </div>

  </body>
</html>