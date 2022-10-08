package com.note.hibernateUtility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.noteTaker.entities.Note;

public class HibernateUtility {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null)
		{
			try {
				Configuration config = new Configuration();
				
				//hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/notetaker?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "Prat9896@");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				
				config.setProperties(settings);
				config.addAnnotatedClass(Note.class);

				sessionFactory = config.buildSessionFactory();
			}catch(Exception e ) { e.printStackTrace();}
		}
		
		return sessionFactory;
		
	}
	
}
