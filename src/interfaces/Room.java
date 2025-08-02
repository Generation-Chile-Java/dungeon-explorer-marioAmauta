package interfaces;

import objects.Player;
import java.util.Scanner;

public interface Room {
    void enter(Player player);

    default void enter(Player player, Scanner scanner) {
        enter(player);
    }
}
