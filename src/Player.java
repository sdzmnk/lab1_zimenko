// Клас, що представляє гравця і реалізує інтерфейс Runnable
class Player implements Runnable {
    private final ChessGame game;
    private final String playerName;

    public Player(ChessGame game, String playerName) {
        this.game = game;
        this.playerName = playerName;
    }

    @Override
    public void run() {
        // Гравець робить 5 ходів
        for (int i = 1; i <= 5; i++) {
            game.makeMove(playerName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Гравець " + playerName + " був перерваний.");
            }
        }
    }
}