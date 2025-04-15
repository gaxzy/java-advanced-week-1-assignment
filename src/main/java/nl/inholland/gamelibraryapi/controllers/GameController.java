package nl.inholland.gamelibraryapi.controllers;

import nl.inholland.gamelibraryapi.models.Game;
import nl.inholland.gamelibraryapi.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/games")
@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Game game = gameService.getGameById(id);
        return (game != null)
                ? ResponseEntity.ok(game)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        if (game.getTitle() == null || game.getPlatform() == null || game.getGenre() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Game saved = gameService.addGame(game);
        return (saved != null)
                ? ResponseEntity.status(HttpStatus.CREATED).body(saved)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
        Game updated = gameService.updateGame(id, game);
        return (updated != null)
                ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGameById(@PathVariable Long id) {
        Game existing = gameService.getGameById(id);
        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
