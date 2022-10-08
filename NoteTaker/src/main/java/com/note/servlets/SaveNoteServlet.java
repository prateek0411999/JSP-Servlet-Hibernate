package com.note.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.note.hibernateUtility.HibernateUtility;
import com.noteTaker.entities.Note;



public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title = request.getParameter("title");
			String content= request.getParameter("content");
			
			//creating Note object
			Note note = new Note(title, content, new Date());
			
			//using hibernate to save this object into database
			SessionFactory factory = HibernateUtility.getSessionFactory();
			Session s = factory.openSession();
			Transaction tx= s.beginTransaction();
			
			s.save(note);
			
			tx.commit();
			s.close();
			
			response.sendRedirect(request.getContextPath() + "/list_notes.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
