package com.example.StudentDemo;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/student")
public class StudentDetails {
		ArrayList<Student> l = new ArrayList<>();
		@PostMapping("/{id}/{name}")
		public ResponseEntity<String> postingdetails(@PathVariable Integer id , @PathVariable String name) {
			for(int i=0;i<l.size();i++) {
				if(id==l.get(i).id) {
					return new ResponseEntity<>("ID already exists", 
							HttpStatus.BAD_REQUEST);
				}
			}
			l.add(new Student(id,name));
			return new ResponseEntity<>("Student added", 
					   HttpStatus.OK);
		}
		@GetMapping("/{id}")
		public String helloGet(@PathVariable Integer id) {
			
			for(int i=0;i<l.size();i++) {
				if(id==l.get(i).id) {
					return l.get(i).name;
				}
			}
			return "Student not found";
			
		}
		@PutMapping("/updatestudent/{id}/{name}")
		public ResponseEntity<String> put(@PathVariable Integer id , @PathVariable String name) {
			
			for(int i=0;i<l.size();i++) {
				if(id==l.get(i).id) {
					l.get(i).name = name;
					return new ResponseEntity<>("Student updated", 
							   HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("Student not found", 
					HttpStatus.BAD_REQUEST);
			
		} 
	
}
