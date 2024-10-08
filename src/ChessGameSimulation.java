import java.util.Random;

public class ChessGameSimulation {
    public static void main(String[] args) {
        // Створюємо гру
        ChessGame game = new ChessGame();

        // Створюємо двох гравців
        Thread player1 = new Thread(new Player(game, "Гравець 1"));
        Thread player2 = new Thread(new Player(game, "Гравець 2"));


        System.out.println("Гра почалась!");
        // Запускаємо обидва потоки
        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            System.out.println("Основний потік був перерваний.");
        }

        // Після завершення всіх ходів вибираємо переможця
        Random random = new Random();
        int winner = random.nextInt(2);
        String winnerName = (winner == 0) ? "Гравець 1" : "Гравець 2";

        System.out.println("========== Гра завершена! ==========");
        System.out.println("🎉 Переможець: " + winnerName + " 🎉");
    }
}
