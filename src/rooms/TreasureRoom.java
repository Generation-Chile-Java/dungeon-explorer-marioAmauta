package rooms;

import interfaces.GameObject;
import interfaces.Room;
import objects.Player;

public class TreasureRoom implements Room {
    private GameObject treasure;

    public TreasureRoom(GameObject treasure) {
        this.treasure = treasure;
    }

    @Override
    public void enter(Player player) {
        System.out.println("¡Encontraste una sala del tesoro!\n");

        treasure.interact(player);
    }
}
