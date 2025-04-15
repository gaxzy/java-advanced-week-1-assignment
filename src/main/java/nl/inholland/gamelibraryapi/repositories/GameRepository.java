package nl.inholland.gamelibraryapi.repositories;

import nl.inholland.gamelibraryapi.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    boolean existsByTitleAndPlatform(String title, String platform);

}
