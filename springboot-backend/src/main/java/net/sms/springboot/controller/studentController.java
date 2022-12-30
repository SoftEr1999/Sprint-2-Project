package net.sms.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sms.springboot.exception.ResourceNotFoundException;
import net.sms.springboot.model.student;
import net.sms.springboot.repository.studentRepository;
import net.sms.springboot.service.studentservice;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class studentController {

	
	@Autowired
	private studentservice studentservice;
	
	// get all students
	@GetMapping("/students")
	public List<student> getAllstudents(){
		return studentservice.findAllStudents();
	}		
	
	// create student rest api
	@PostMapping("/students")
	public student createstudent(@RequestBody student student) {
		return studentservice.addNewStudent(student);
	}
	
	// get student by id rest api
	@GetMapping("/students/{id}")
	public ResponseEntity<student> getstudentById(@PathVariable Long id) {
		student student = studentservice.getStudentById(id);
				return ResponseEntity.ok(student);
	}
	
	// update student rest api
	
	@PutMapping("/students/{id}")
	public ResponseEntity<student> updatestudent(@PathVariable Long id, @RequestBody student studentDetails){
		student updatedstudent = studentservice.studentUpdation(id, studentDetails);
	
		return ResponseEntity.ok(updatedstudent);
	}
	
	// delete student rest api
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deletestudent(@PathVariable Long id){
		
		return ResponseEntity.ok(studentservice.studentDeletion(id));
	}
	
	
}
