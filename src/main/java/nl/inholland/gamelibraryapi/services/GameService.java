package nl.inholland.gamelibraryapi.services;

import nl.inholland.gamelibraryapi.models.Game;

import java.util.List;


public interface GameService {

    List<Game> getAllGames();

    Game getGameById(Long id);

    Game addGame(Game game);

    Game updateGame(Long id, Game game);

    void deleteGame(Long id);

}
