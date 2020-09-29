package org.websparrow.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.websparrow.entity.Student;
import org.websparrow.model.Response;
import org.websparrow.service.StudentService;

@RestController(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<Response> get() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(studentService.get(), new Date()));
	}

	@PostMapping
	public ResponseEntity<Response> save(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(studentService.save(student), new Date()));
	}

	@PutMapping
	public ResponseEntity<Response> update(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(studentService.save(student), new Date()));
	}

	@DeleteMapping
	public ResponseEntity<Response> delete(@RequestParam("id") int id) {
		studentService.delete(id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(true, new Date()));
	}
}
