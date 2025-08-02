import interfaces.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import objects.Enemy;
import objects.Question;
import objects.QuestionBank;
import objects.Treasure;
import rooms.EmptyRoom;
import rooms.EnemyRoom;
import rooms.TreasureRoom;

public class DungeonGame {
    private static final String[] TREASURES = {
            "Libro de Hechizos React",
            "Escudo de Componentes",
            "Espada de JSX",
            "Poción de Estado",
            "Amuleto de Hooks",
            "Mapa de Rutas",
            "Botas de Renderizado",
            "Anillo de useEffect",
            "Capa de Contexto",
            "Pergamino de Props"
    };

    private static final String[] ENEMIES = {
            "Error de dependencias en useEffect",
            "Renderizado infinito",
            "Estado no actualizado",
            "Props no pasadas correctamente",
            "Key duplicada en lista",
            "Warning de StrictMode",
            "Ciclo de vida incorrecto",
            "Declaración de componente incorrecta",
            "Re-render innecesario",
            "Contexto no actualizado"
    };

    public static Room[] generateRandomDungeon(int numberOfRooms) {
        Random random = new Random();

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < numberOfRooms; i++) {
            int roomType = random.nextInt(3); // 0: EmptyRoom, 1: TreasureRoom, 2: EnemyRoom

            switch (roomType) {
                case 0:
                    rooms.add(new EmptyRoom());

                    break;
                case 1:
                    String treasure = TREASURES[random.nextInt(TREASURES.length)];

                    rooms.add(new TreasureRoom(new Treasure(treasure)));

                    break;

                case 2:
                    String enemyName = ENEMIES[random.nextInt(ENEMIES.length)];
                    int enemyDamage = random.nextInt(20) + 10; // Damage between 10 and 30
                    Question question = QuestionBank.getRandomQuestion();

                    Enemy enemy = new Enemy(enemyName, enemyDamage, question);

                    rooms.add(new EnemyRoom(enemy));

                    break;
            }
        }

        return rooms.toArray(new Room[0]);
    }
}
