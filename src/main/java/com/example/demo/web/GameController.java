package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Game;
import com.example.demo.service.GameService;

@RestController // tells Spring this is a controller :)
//Rest compliant (Representational State Transfer)
public class GameController {

	@GetMapping("/helloWorld") // THIS IS AN ENDPOINT!!!1111
	public String hello() {
		return "Hello world!";
	}

	// ResponseEntity - an extension of HttpEntity that represents an Http response
	// including
	// status, headers and body

	private GameService service;

	@Autowired // tells Spring to fetch the GameService from the context - dependency injection
	public GameController(GameService service) {
		super();
		this.service=service;
	}

	@PostMapping("/create") // @RequestBody pulls the parameter from the body of the request

	public ResponseEntity<Game> createGame(@RequestBody Game g) {
		Game created = this.service.createGame(g);
		ResponseEntity<Game> response = new ResponseEntity<Game>(created, HttpStatus.CREATED); // 201 - created
		return response;
	}
	
	@GetMapping("/getAll") 
	public ResponseEntity<List<Game>> getAllgames() {
		return ResponseEntity.ok(this.service.getAllgames()); //200 - ok
	}
	
	@GetMapping("/get/{id}")  // 200 ok
	public Game getGame(@PathVariable Integer id) {
		return this.service.getGame(id);
	}
	@PutMapping("/replace/{id}") // 202 accepted
	public ResponseEntity<Game> replaceGame(@PathVariable Integer id, @RequestBody Game newGame) {
		Game body = this.service.replaceGame(id, newGame);
		ResponseEntity<Game> response = new ResponseEntity<Game>(body, HttpStatus.ACCEPTED);
		return response;
	}
	@DeleteMapping("/remove/{id}") // 204 no content 
	public ResponseEntity<?> removeGame(@PathVariable Integer id) {
		this.service.removeGame(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
