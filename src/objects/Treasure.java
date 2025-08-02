package objects;

import interfaces.GameObject;

public class Treasure implements GameObject {
    private String name;

    public Treasure(String name) {
        this.name = name;
    }

    @Override
    public void interact(Player player) {
        player.addToInventory(name);
    }
}
