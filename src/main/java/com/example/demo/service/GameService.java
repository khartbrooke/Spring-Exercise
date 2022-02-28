package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Game;

@Service
public class GameService {

	private List<Game> games = new ArrayList<>();

	// CREATEs
	public Game createGame(Game g) {
		this.games.add(g);
		Game created = this.games.get(this.games.size() - 1);
		return created;
	}

	// READ
	public List<Game> getAllgames() {
		return this.games;
	}

	public Game getGame(Integer id) {
		return this.games.get(id);
	}

	// UPDATE
	public Game replaceGame(Integer id, Game newGame) {
		Game body = this.games.set(id, newGame);
		return body;
	}

	// DELETE
	public void removeGame(@PathVariable Integer id) {
		this.games.remove(id.intValue());
	}
}
