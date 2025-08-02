package objects;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<String> inventory;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getInventory() {
        return new ArrayList<>(inventory);
    }

    public void takeDamage(int damage) {
        health -= damage;

        System.out.println(
                name + " recibiste " + damage + " de daño. Salud restante: " + (health < 0 ? 0 : health) + ".\n");
    }

    public void addToInventory(String item) {
        inventory.add(item);

        System.out.println(name + " recogiste: " + item + ".\n");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void showStatus() {
        System.out.println(
                "Jugador: " + name + ", Salud: " + (health < 0 ? 0 : health) + ", Inventario: " + inventory + ".\n");
    }

    public boolean hasTreasures() {
        return !inventory.isEmpty();
    }

    public boolean useTreasure(String treasureName) {
        if (inventory.contains(treasureName)) {
            inventory.remove(treasureName);

            System.out.println("\n" + name + " usaste: " + treasureName + " para evitar el daño!\n");

            return true;
        }

        return false;
    }
}