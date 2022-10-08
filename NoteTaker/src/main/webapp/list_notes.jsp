<%@page import="com.noteTaker.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="jakarta.persistence.Query"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.note.hibernateUtility.HibernateUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@include file="all_js_css.jsp" %>
<title>All Notes: NoteTaker</title>
</head>
<body>
	<div class="container-fluid">
    	<%@include file="navbar.jsp"%>
    </div>
    
    <div class="container">
    	<div class="row">
    		<div class="col-12">
    			<%
			    	SessionFactory factory = HibernateUtility.getSessionFactory();
			    	Session s = factory.openSession();	
			    	Query q = s.createQuery("from notes");
			    	List<Note> list = q.getResultList();
			    	
			    	for(Note note:list)
			    	{
			    		%>
			    		 <div class="card mb-2 mt-2">
			    		 	<div class="card-body">
			    		 		<h5 class="card-title">Title: &nbsp;<%= note.getTitle() %></h5>
			    		 		<p class="card-text">Content: &nbsp;<%= note.getContent() %></p>
			    		 		<div>
			    		 			<p>Created At: &nbsp; <%= note.getCreated_at() %></p>
			    		 		</div>
			    		 		<div>
			    		 		<a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger"> Delete </a>
			    		 		<a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-primary"> Update </a>
			    		 		</div>
			    		 	</div>
			    		 </div>
			    		<%
			    		
			
			    	}
			    	s.close();
			    
			    %>
    		</div>
    	</div>
    	
    </div>
</body>
</html>
