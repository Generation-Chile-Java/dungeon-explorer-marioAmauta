package objects;

import interfaces.GameObject;
import java.util.Scanner;

public class Enemy implements GameObject {
    private String name;
    private int damage;
    private Question question;

    public Enemy(String name, int damage, Question question) {
        this.name = name;
        this.damage = damage;
        this.question = question;
    }

    @Override
    public void interact(Player player) {
        interact(player, new Scanner(System.in));
    }

    public void interact(Player player, Scanner scanner) {
        System.out.println("¡" + name + " apareció!");
        System.out.println("Para derrotarlo, debes responder correctamente esta pregunta de ReactJS:\n");

        question.displayQuestion();

        int playerAnswer;

        try {
            playerAnswer = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Respuesta inválida. Se considerará como incorrecta.");

            playerAnswer = -1;
        }

        if (question.isCorrect(playerAnswer)) {
            scanner.nextLine(); // consume the leftover newline character

            System.out.println("\n¡Correcto! Has derrotado a " + name + "!\n");
        } else {
            scanner.nextLine(); // consume the leftover newline character

            System.out.println(
                    "\nRespuesta incorrecta. La respuesta correcta era: " + question.getCorrectAnswer() + "\n");
            System.out.println("¡" + name + " está a punto de atacarte!\n");

            if (player.hasTreasures()) {
                System.out.println("Tienes tesoros en tu inventario: " + player.getInventory());
                System.out.print("\n¿Quieres usar un tesoro para evitar el daño? (s/n): ");

                String useTreasure = scanner.nextLine().toLowerCase();

                if (useTreasure.equals("s") || useTreasure.equals("si")) {
                    System.out.println("\nElige qué tesoro usar:\n");

                    for (int i = 0; i < player.getInventory().size(); i++) {
                        System.out.println((i + 1) + ". " + player.getInventory().get(i));
                    }

                    System.out.print("\nTu elección (1-" + player.getInventory().size() + "): ");

                    try {
                        int treasureChoice = scanner.nextInt();

                        if (treasureChoice >= 1 && treasureChoice <= player.getInventory().size()) {
                            String selectedTreasure = player.getInventory().get(treasureChoice - 1);

                            if (player.useTreasure(selectedTreasure)) {
                                scanner.nextLine(); // consume the leftover newline character

                                System.out.println("El poder del tesoro te protege del ataque de " + name + "!\n");

                                return; // Exit without taking damage
                            }
                        } else {
                            System.out.println("\nElección inválida. No se usará ningún tesoro.\n");
                        }
                    } catch (Exception e) {
                        System.out.println("\nElección inválida. No se usará ningún tesoro.\n");
                    }
                } else {
                    System.out.println("\nDecidiste no usar ningún tesoro.\n");
                }
            } else {
                System.out.println("No tienes tesoros para protegerte.\n");
            }

            System.out.println("¡" + name + " te ataca!\n");

            player.takeDamage(damage);
        }
    }
}
