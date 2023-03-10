import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.NotRegisteredException.NotRegisteredException;
import ru.netology.domain.Player;
import ru.netology.manager.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {
    Game game = new Game();
    Player pet = new Player(1, "Петруха", 5);
    Player kir = new Player(2, "Кирюха", 4);
    Player dim = new Player(3, "Димарик", 4);
    Player kol = new Player(4, "Колямба", 2);
    Player an = new Player(5, "Антонио", 1);

    @BeforeEach
    public void setup() {
        game.register(pet);
        game.register(kir);
        game.register(dim);
        game.register(kol);
        game.register(an);
    }

    @Test
    public void shouldFindPlayersStrength2() {
        int expected = (2);
        int actual = game.round("Антонио", "Колямба");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayersStrength1() {
        int expected = (1);
        int actual = game.round("Петруха", "Колямба");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayersStrengthEquals() {
        int expected = (0);
        int actual = game.round("Димарик", "Кирюха");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayersNotExist1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Лысый", "Антонио"));
    }

    @Test
    public void shouldFindPlayersNotExist2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Колямба", "Топор"));
    }

    @Test
    public void shouldFindPlayersNotExist3() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Лысый", "Топор"));
    }
}
