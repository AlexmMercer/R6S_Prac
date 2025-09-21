package r6s.game;

import r6s.operators.*;
import r6s.map.GameMap;
import r6s.battle.Turn;
import java.util.Scanner;
import static r6s.Constants.*;

/**
 * Основной класс игры, управляющий игровым циклом
 *
 * TODO: Реализовать следующие методы:
 * 1. initializeGame() - инициализация карты и операторов
 * 2. isGameOver() - проверка условий окончания игры
 * 3. announceWinner() - объявление победителя
 */
public class Game {
    private GameMap map;
    private Operator[] attackers;
    private Operator[] defenders;
    private Turn turnManager;
    private int currentTurn = 0;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        initializeGame();

        // TODO: Написать игровой цикл
        // Подсказка:
        // while (!isGameOver()) {
        //     System.out.println("\n=== ХОД " + (currentTurn + 1) + " ===");
        //     map.display(attackers, defenders);
        //
        //     if (currentTurn % 2 == 0) {
        //         // Ход атакующих
        //         turnManager.executeAttackerTurn(attackers);
        //     } else {
        //         // Ход защитников
        //         turnManager.executeDefenderTurn(defenders);
        //     }
        //     currentTurn++;
        // }

        announceWinner();
    }

    private void initializeGame() {
        System.out.println("Инициализация игры...");

        // TODO: Реализовать инициализацию
        // Шаги:
        // 1. Создать карту: map = new GameMap();
        // 2. Создать операторов: attackers = OperatorFactory.createAttackers();
        // 3. Создать защитников: defenders = OperatorFactory.createDefenders();
        // 4. Разместить атакующих на стартовых позициях:
        //    attackers[0].setRow(ATTACKER_START_ROW); attackers[0].setCol(ATTACKER_START_COL_1);
        //    attackers[1].setRow(ATTACKER_START_ROW); attackers[1].setCol(ATTACKER_START_COL_2);
        // 5. Разместить защитников на стартовых позициях:
        //    defenders[0].setRow(DEFENDER_START_ROW); defenders[0].setCol(DEFENDER_START_COL_1);
        //    defenders[1].setRow(DEFENDER_START_ROW); defenders[1].setCol(DEFENDER_START_COL_2);
        // 6. Создать менеджер ходов: turnManager = new Turn(map, scanner);

        System.out.println("Игра инициализирована!");
        System.out.println("Атакующие: " + attackers[0].getName() + ", " + attackers[1].getName());
        System.out.println("Защитники: " + defenders[0].getName() + ", " + defenders[1].getName());
    }

    private boolean isGameOver() {
        // TODO: Проверить условия окончания игры
        // Возвращает true если:
        // 1. Любой атакующий достиг центра карты (row == MAP_SIZE/2 && col == MAP_SIZE/2)
        // 2. Все атакующие мертвы (!attacker.isAlive())
        // 3. Прошло MAX_TURNS ходов (currentTurn >= MAX_TURNS)

        return false; // Заменить на реальную логику
    }

    private void announceWinner() {
        // TODO: Определить и объявить победителя
        // Логика:
        // 1. Если любой атакующий на цели - "Атакующие победили! Цель захвачена!"
        // 2. Если все атакующие мертвы - "Защитники победили! Все атакующие устранены!"
        // 3. Если время вышло - "Защитники победили! Время вышло!"

        System.out.println("Игра окончена!");
    }

    // Вспомогательные методы для проверки
    private boolean areAllAttackersDead() {
        for (Operator attacker : attackers) {
            if (attacker.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private boolean hasAttackerReachedObjective() {
        for (Operator attacker : attackers) {
            if (attacker.isAlive() &&
                attacker.getRow() == MAP_SIZE/2 &&
                attacker.getCol() == MAP_SIZE/2) {
                return true;
            }
        }
        return false;
    }
}