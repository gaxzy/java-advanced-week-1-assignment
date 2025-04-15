package nl.inholland.gamelibraryapi.services;

import nl.inholland.gamelibraryapi.models.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GameServiceImpl implements GameService {

    private final List<Game> games = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public GameServiceImpl() {
        addDefaultGame("The Legend of Zelda: Breath of the Wild", "Adventure", "Nintendo Switch");
        addDefaultGame("God of War", "Action", "PlayStation 5");
        addDefaultGame("Halo Infinite", "FPS", "Xbox Series X");
        addDefaultGame("Minecraft", "Sandbox", "Multi-platform");
        addDefaultGame("Elden Ring", "RPG", "Multi-platform");

    }

    private void addDefaultGame(String title, String genre, String platform) {
        Game game = new Game();
        game.setId(idCounter.getAndIncrement());
        game.setTitle(title);
        game.setGenre(genre);
        game.setPlatform(platform);
        games.add(game);
    }

    @Override
    public List<Game> getAllGames() {
        return new ArrayList<>(games);
    }

    @Override
    public Game getGameById(Long id) {
        return games.stream()
                .filter(game -> game.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Game addGame(Game game) {
        boolean exists = games.stream()
                .anyMatch(g -> g.getTitle().equals(game.getTitle())
                        && g.getPlatform().equals(game.getPlatform()));

        if (exists) {
            return null;
        }

        game.setId(idCounter.getAndIncrement());
        games.add(game);
        return game;
    }

    @Override
    public Game updateGame(Long id, Game game) {
        for (Game existingGame : games) {
            if (existingGame.getId().equals(id)) {
                existingGame.setTitle(game.getTitle());
                existingGame.setGenre(game.getGenre());
                existingGame.setPlatform(game.getPlatform());
                return existingGame;
            }
        }
        return null;
    }

    @Override
    public void deleteGame(Long id) {
        games.removeIf(game -> game.getId().equals(id));
    }
}
