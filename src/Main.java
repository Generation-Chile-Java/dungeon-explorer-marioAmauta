import interfaces.Room;
import java.util.Scanner;
import objects.Player;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a Dungeon Game: ReactJS Quiz Edition!\n");
        System.out.println(
                "Las sombras se ciernen sobre ti mientras te adentras en un calabozo repleto de misterios y peligros.");
        System.out.println(
                "Solo tu ingenio y tus conocimientos de ReactJS podrán salvarte de las trampas mortales que acechan en cada habitación.");
        System.out.println("Responde correctamente para sobrevivir y avanzar... cada error podría ser el último.");
        System.out.println("\n¿Estás listo para desafiar al destino? ¡Que comience la aventura!\n");

        System.out.print("Ingresa tu nombre: ");

        String playerName = scanner.nextLine();

        if (playerName.isEmpty()) {
            System.out.println("\nNombre inválido. Se asignará 'Usuario Incognito'.");

            playerName = "Usuario Incognito";
        }

        // Adding a line break for better readability
        System.out.println();

        Player player = new Player(playerName, 100);

        Room[] dungeons = DungeonGame.generateRandomDungeon(30);

        for (int i = 0; i < dungeons.length; i++) {
            if (!player.isAlive()) {
                System.out.println(player.getName() + " has muerto. Fin del juego.");

                break;
            }

            System.out.println("=======================================\n");
            System.out.println("Room " + (i + 1) + ": Presiona Enter para entrar...");

            scanner.nextLine();

            dungeons[i].enter(player, scanner);

            player.showStatus();
        }

        if (player.isAlive()) {
            System.out.println("¡Felicidades, " + player.getName() + "!\n");
            System.out.println(
                    "Has superado todas las habitaciones del calabozo y demostrado tus conocimientos de ReactJS.");
            System.out.println(
                    "Tus logros quedarán marcados en la historia, y los conocimientos adquiridos te ayudarán en futuros desafíos.");
            System.out.println("\n¡Gracias por jugar Dungeon Explorer: ReactJS Quiz Edition!");
        }

        System.out.println("\nHasta la próxima aventura, " + player.getName() + "!");

        scanner.close();
    }
}
