package nl.inholland.gamelibraryapi.repositories;

import jakarta.annotation.PostConstruct;
import nl.inholland.gamelibraryapi.models.Game;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final GameRepository gameRepository;

    public DataInitializer(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void init() {
        if (gameRepository.count() == 0) {
            gameRepository.save(new Game(null, "The Witcher 3", "RPG", "PC"));
            gameRepository.save(new Game(null, "God of War", "Action", "PlayStation"));
            gameRepository.save(new Game(null, "Zelda: Breath of the Wild", "Adventure", "Switch"));
        }
    }

}
