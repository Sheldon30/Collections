import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<Player, Player> players = new HashMap<>();


    public void register(Player player) {
        players.put(player, player);
    }

    public Player findByName(String playerName) {
        for (Player key : players.keySet()) {
            if (key.getName() == playerName) {
                return key;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException(
                    "Игрок(и) не зарегестрирован(ы)!"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }


}
