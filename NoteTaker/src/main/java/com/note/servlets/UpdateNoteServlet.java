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

/**
 * Servlet implementation class UpdateNoteServlet
 */
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String title = request.getParameter("title");
			String content= request.getParameter("content");
			int note_id = Integer.parseInt(request.getParameter("note_id"));
		
			
			//using hibernate to save this object into database
			SessionFactory factory = HibernateUtility.getSessionFactory();
			Session s = factory.openSession();
			Transaction tx= s.beginTransaction();
			Note note = s.get(Note.class, note_id);
			note.setContent(content);
			note.setTitle(title);
			s.save(note);
			
			tx.commit();
			s.close();
			
			response.sendRedirect(request.getContextPath() + "/list_notes.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
