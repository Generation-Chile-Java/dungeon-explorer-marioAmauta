package rooms;

import interfaces.Room;
import objects.Enemy;
import objects.Player;
import java.util.Scanner;

public class EnemyRoom implements Room {
    private Enemy enemy;

    public EnemyRoom(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void enter(Player player) {
        enter(player, new Scanner(System.in));
    }

    public void enter(Player player, Scanner scanner) {
        System.out.println("¡Entraste a una sala con un enemigo!\n");

        enemy.interact(player, scanner);
    }
}
