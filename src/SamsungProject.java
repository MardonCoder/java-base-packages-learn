import java.util.Scanner;

public class SamsungProject {
    public static void main(String[] args) {
        int step = 0, personX, personY, sizeBoard = 5;
        personX = sizeBoard / 2 + 1;
        personY = sizeBoard / 2 + 1;
        String person = "\uD83E\uDDD9\u200D";
        String monster = "\uD83E\uDDDF\u200D";
        String castle = "\uD83C\uDFF0";

        String gamingField = "+ -- + -- + -- +\n" +
                             "|    |    |    |\n" +
                             "+ -- + -- + -- +\n" +
                             "|    |    |    |\n" +
                             "+ -- + -- + -- +\n" +
                             "|    |    |    |\n" +
                             "+ -- + -- + -- +\n";

        Scanner scanner = new Scanner(System.in);

        // Game logic:
        System.out.print("Ты готов? ");
        String answer = scanner.nextLine();
        if (answer.equals("ДА")) {
            System.out.println("Начинаем играть");
        } else {
            System.out.println("Почему ты не захотел со мной играть(");
            System.out.println("Приходи ещё!");
        }

        System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на " +
                "одну клетку;");
        System.out.println("Координаты персонажа - (x: " + personX + ", y: " + personY + "))");

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x != personX && y != personY) {
            System.out.println("Неккоректный ход");
        } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
            personX = x;
            personY = y;
            step += 1;
            System.out.println("Ход корректный; Новые координаты: " +
                    personX + ", " + personY + "\nХод номер: " + step);
        } else {
            System.out.println("Координаты не изменены");
        }
    }
}
