package nl.inholland.gamelibraryapi.services;

import nl.inholland.gamelibraryapi.models.Game;
import nl.inholland.gamelibraryapi.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game addGame(Game game) {
        boolean exists = gameRepository.existsByTitleAndPlatform(game.getTitle(), game.getPlatform());
        if (exists) {
            return null;
        }
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Long id, Game game) {
        return gameRepository.findById(id)
                .map(existingGame -> {
                    existingGame.setTitle(game.getTitle());
                    existingGame.setGenre(game.getGenre());
                    existingGame.setPlatform(game.getPlatform());
                    return gameRepository.save(existingGame);
                })
                .orElse(null);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
