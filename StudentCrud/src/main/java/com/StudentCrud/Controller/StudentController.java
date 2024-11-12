package com.StudentCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCrud.Model.Student;
import com.StudentCrud.Repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController{

	@Autowired
	private StudentRepository studentRepository;
	
	  @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentRepository.save(student);
	    }
	  
	  @GetMapping
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }
	  
	  @GetMapping("/{id}")
	  public Student getStudentById(@PathVariable Long id) {
	      return studentRepository.findById(id).orElse(null);
	  }
	  
	  @PutMapping("/{id}")
	  public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
	      Student student = studentRepository.findById(id).orElse(null);
	      
	      if (student != null) {
	          student.setName(updatedStudent.getName());
	          student.setAge(updatedStudent.getAge());
	          student.setEmail(updatedStudent.getEmail());
	          student.setCourse(updatedStudent.getCourse());
	          return studentRepository.save(student);
	      } else {
	          return null;
	      }
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
	      Student student = studentRepository.findById(id).orElse(null);

	      if (student != null) {
	          studentRepository.delete(student);
	          return ResponseEntity.ok().build();
	      } else {
	          return ResponseEntity.notFound().build();
	      }
	  }
}
