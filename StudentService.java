package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.StudentDAO;
import com.tka.entity.Student;

@Service
public class StudentService {
	@Autowired
	StudentDAO dao;

	public String insertData(Student s) {
		String msg = dao.insertData(s);
		return msg;
	}

	public String deleteData(int stud_id) {
		String msg = dao.deletData(stud_id);
		return msg;
	}

	public String updateData(Student s, int stud_id) {
		String msg = dao.updateData(s, stud_id);
		return msg;
	}

	public Student getSingleData(int stud_id) {
		Student s = dao.getSingleData(stud_id);
		return s;
	}

	public List<Student> getAllRecord() {
		List<Student>list=dao.getAllRecord();
		return list;
	}
}
