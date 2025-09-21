package r6s;

import r6s.game.Game;

/**
 * Главный класс для запуска игры Rainbow Six Siege: Breach Simulator
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RAINBOW SIX SIEGE: BREACH SIMULATOR ===");
        System.out.println("Добро пожаловать в тактический симулятор!");
        System.out.println();

        Game game = new Game();
        game.start();
    }
}