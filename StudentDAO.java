package com.tka.dao;

import java.util.List;
import java.util.Queue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Student;

@Repository
public class StudentDAO {
	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(s);
		transaction.commit();
		session.close();
		return "Data is inserted...";
	}

	public String deletData(int stud_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Student s1 = session.get(Student.class, stud_id);
		session.remove(s1);
		transaction.commit();
		session.close();
		return "Data is deleted...";
	}

	public String updateData(Student s, int stud_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Student s1 = session.get(Student.class, stud_id);
		s1.setStud_name(s.getStud_name());
		s1.setStud_city(s.getStud_city());
		session.merge(s1);
		session.close();
		return "Data is updated...";

	}

	public Student getSingleData(int stud_id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "from Student where stud_id=:myid";
		Query<Student> query = session.createQuery(hqlQuery, Student.class);
		query.setParameter("myid", stud_id);
		Student s1 = query.uniqueResult();
		transaction.commit();
		session.close();
		return s1;
	}

	public List<Student> getAllRecord() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "from Student ";
		Query<Student> query = session.createQuery(hqlQuery);
		List<Student> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}
}
