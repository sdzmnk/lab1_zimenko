import java.util.concurrent.Semaphore;

// Клас для представлення гри в шахи
class ChessGame {
    // Семафор для контролю черги гравців
    private final Semaphore semaphore = new Semaphore(1);
    private int moveNumber = 1; // Лічильник ходів

    // Метод для імітації ходу гравця
    public void makeMove(String playerName) {
        try {
            // Гравець чекає своєї черги
            semaphore.acquire();

            System.out.println("Хід " + moveNumber + ":");
            System.out.println("------------------------------------");
            System.out.println((playerName.equals("Гравець 1") ? "🔵" : "🔴") + " " + playerName + " робить хід...");
            System.out.println("⏳ Час на роздуми...");
            Thread.sleep(1000);
            System.out.println("✅ " + playerName + " завершив хід.");
            System.out.println("------------------------------------\n");
            moveNumber++;

        } catch (InterruptedException e) {
            System.out.println("Гравець " + playerName + " був перерваний.");
        } finally {
            // Дозволити іншому гравцю зробити хід
            semaphore.release();
        }
    }
}



