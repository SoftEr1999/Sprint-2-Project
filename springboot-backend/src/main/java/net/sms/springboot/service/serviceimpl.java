package net.sms.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sms.springboot.exception.ResourceNotFoundException;
import net.sms.springboot.model.student;
import net.sms.springboot.repository.studentRepository;

@Service
public class serviceimpl implements studentservice {

	@Autowired
	private studentRepository studentRepository;
	
	@Override
	public List<student> findAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public student addNewStudent(student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public student getStudentById(Long id) {
		student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
		return student;
	}

	@Override
	public student studentUpdation(Long id, student studentDetails) {
		student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
		
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmailId(studentDetails.getEmailId());
		
		student updatedstudent = studentRepository.save(student);
		return updatedstudent;
	}

	@Override
	public Map<String, Boolean> studentDeletion(Long id) {
		student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
		
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
