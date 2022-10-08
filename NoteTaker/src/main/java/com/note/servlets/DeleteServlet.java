package com.note.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.note.hibernateUtility.HibernateUtility;
import com.noteTaker.entities.Note;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int note_id = Integer.parseInt(request.getParameter("note_id"));
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Note note = s.get(Note.class, note_id);
		s.delete(note);
		tx.commit();
		s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("list_notes.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
