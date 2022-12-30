package net.sms.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sms.springboot.model.student;


public interface studentservice {

	List<student> findAllStudents();
	student addNewStudent(student student);
	student getStudentById(Long id);
	student studentUpdation(Long id,student student);
	Map<String,Boolean> studentDeletion(Long id);
}
