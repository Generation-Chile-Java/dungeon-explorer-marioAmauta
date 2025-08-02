package rooms;

import interfaces.Room;
import objects.Player;

public class EmptyRoom implements Room {
    @Override
    public void enter(Player player) {
        System.out.println("Entraste a una sala vacía. Nada que ver aquí.\n");
    }
}
