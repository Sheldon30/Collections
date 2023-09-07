import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player kolya = new Player(1, "Коля", 50);
    Player sveta = new Player(3, "Света", 150);
    Player gosha = new Player(5, "Гоша", 200);
    Player katya = new Player(7, "Катя", 230);
    Player nika = new Player(9, "Вероника", 200);

    @Test
    //Оба игрока зарегестрированы (выигрывает первый).
    public void playerIsRegister() {
        Game game = new Game();
        game.register(kolya);
        game.register(sveta);
        game.register(katya);

        int expected = 1;
        int actual = game.round("Катя", "Света");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    //Оба игрока зарегестрированы (выигрывает второй).
    public void playerIsRegisterAll() {
        Game game = new Game();
        game.register(kolya);
        game.register(sveta);

        int expected = 2;
        int actual = game.round("Коля", "Света");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    //Оба игрока зарегестрированы (ничья).
    public void playerIsRegisterDraw() {
        Game game = new Game();
        game.register(sveta);
        game.register(katya);
        game.register(gosha);
        game.register(nika);

        int expected = 0;
        int actual = game.round("Гоша", "Вероника");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    //Не зарегестрирован один игрок.
    public void onePlayerIsNotRegister() {
        Game game = new Game();
        game.register(kolya);
        game.register(sveta);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Коля", "Катя");
        });

    }
    @Test
    //Не зарегестрированы оба игрока.
    public void TwoPlayerIsNotRegister() {
        Game game = new Game();
        game.register(kolya);
        game.register(sveta);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Гоша", "Вероника");
        });

    }
}
